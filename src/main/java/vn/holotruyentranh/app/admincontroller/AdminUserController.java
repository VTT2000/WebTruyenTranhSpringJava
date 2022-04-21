package vn.holotruyentranh.app.admincontroller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.holotruyentranh.app.bean.Comic;
import vn.holotruyentranh.app.bean.User;
import vn.holotruyentranh.app.service.UserService;
@Controller
@RequestMapping("/admin")
public class AdminUserController {
	@Autowired
	private UserService UserDao;
	@RequestMapping("/user")
	public String index(Model model, HttpSession session, HttpServletRequest request){
		return listByPage(model, 1, session, request);
	}
	@RequestMapping("/user_{pageNum}")
	public String listByPage(Model model, @PathVariable(name = "pageNum") int currentPage, HttpSession session, HttpServletRequest request){
		Cookie[] cookies = null;
        cookies = request.getCookies();
		if(cookies.length != 0) {
	        for (int i = 0; i < cookies.length; i++) {
	        	Cookie cookie = null;
	        	cookie = cookies[i];
	        	if ((cookie.getName()).compareTo("AdminName") == 0) {
	        		session.setAttribute("AdminName", cookie.getValue());
                }
	        	if ((cookie.getName()).compareTo("AdminIdKH") == 0) {
	        		session.setAttribute("AdminIdKH", cookie.getValue());
                }
	        }
		}
		if(
				session.getAttribute("AdminName") == null &&
				session.getAttribute("AdminIdKH") == null) {
			return "redirect:/admin/login";
		}
		Page<User> page = UserDao.listAll(currentPage);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		List<User> list = page.getContent();
		
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("listUsers", list);
		return "admin/adminuser/user";
	}

	@RequestMapping(value = "/user_insert", method = RequestMethod.GET)
	public String insert(Model model){	
		model.addAttribute("error","");
		return "admin/adminuser/insert";
	}
	
	@RequestMapping(value = "/user_insert", method = RequestMethod.POST)
	public String insert0(@ModelAttribute User user0, Model model, HttpServletRequest request){
		List<User> list0 = UserDao.listAll();
		User a = null;
		for (User user : list0) {
			if(user0.getUsername().compareTo(user.getUsername()) == 0) {
				model.addAttribute("error","người dùng đã tồn tại");
				return "admin/adminuser/insert"; 
			}
		}
		Date date = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");  
        String strDate = formatter.format(date);
        user0.setCreated(strDate);
        user0.setUpdated(strDate);
     
		UserDao.save(user0);
		model.addAttribute("error","Thành công thêm người dùng");
		return "admin/adminuser/insert";
	}
	
	@RequestMapping(value = "/user_edit", method = RequestMethod.GET)
	public String edit(Model model, HttpServletRequest request){
		Long idLong = Long.parseLong(request.getParameter("id"));
		User aUser = UserDao.get(idLong);
		model.addAttribute("temp", aUser);
		model.addAttribute("error","");
		return "admin/adminuser/edit";
	}
	
	@RequestMapping(value = "/user_edit", method = RequestMethod.POST)
	public String edit0(@ModelAttribute User user0, Model model, HttpServletRequest request){
		List<User> list0 = UserDao.listAll();
		User a = null;
		for (User user : list0) {
			if(user.getIDuser().compareTo(user0.getIDuser()) != 0 && user0.getUsername().compareTo(user.getUsername()) == 0) {
				model.addAttribute("error","người dùng đã tồn tại");
				model.addAttribute("temp", user0);
				return "admin/adminuser/edit";
			}
		}
		
		Date date = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");  
        String strDate = formatter.format(date);
        user0.setUpdated(strDate);
		UserDao.save(user0);
		model.addAttribute("temp", user0);
		model.addAttribute("error","Thành công cập nhật người dùng");
		return "admin/adminuser/edit";
	}
	
	@RequestMapping("/deleteuser/{IDuser}")
	public String deleteuser(@PathVariable(name = "IDuser") Long IDuser) {
		UserDao.delete(IDuser);
		return "redirect:/admin/user";
	}
}
