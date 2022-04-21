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

import vn.holotruyentranh.app.bean.Author;
import vn.holotruyentranh.app.service.AuthorService;

@Controller
@RequestMapping("/admin")
public class AdminAuthorController {
	@Autowired
	private AuthorService authorDao;
	@RequestMapping("/author")
	public String index(Model model, HttpSession session, HttpServletRequest request){
		return listByPage(model, 1, session, request);
	}
	
	@RequestMapping("/author_{pageNum}")
	public String listByPage(Model model, @PathVariable(name = "pageNum") int currentPage, HttpSession session, HttpServletRequest request) {
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
		
		Page<Author> page = authorDao.listAll(currentPage);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		List<Author> list = page.getContent();
		
		model.addAttribute("listAuthors", list);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", currentPage);
		
		
		return "admin/adminauthor/author";
	}
	
	
	
	
	@RequestMapping(value = "/author_insert", method = RequestMethod.GET)
	public String insert(Model model){	
		model.addAttribute("error","");
		return "admin/adminauthor/insert";
	}
	
	@RequestMapping(value = "/author_insert", method = RequestMethod.POST)
	public String insert0(@ModelAttribute Author author0, Model model, HttpServletRequest request){
		List<Author> list0 = authorDao.listAll();
		Author a = null;
		for (Author author : list0) {
			if(author0.getAuthor().compareTo(author.getAuthor()) == 0) {
				model.addAttribute("error","Tác giả đã tồn tại");
				return "admin/adminauthor/insert"; 
			}
		}
		Date date = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");  
        String strDate = formatter.format(date);
        author0.setCreated(strDate);
        author0.setUpdated(strDate);
     
		authorDao.save(author0);
		model.addAttribute("error","Thành công thêm tác giả");
		return "admin/adminauthor/insert";
	}
	
	@RequestMapping(value = "/author_edit", method = RequestMethod.GET)
	public String edit(Model model, HttpServletRequest request){	
		Long idLong = Long.parseLong(request.getParameter("id"));
		Author aAuthor = authorDao.get(idLong);
		model.addAttribute("temp", aAuthor);
		model.addAttribute("error","");
		return "admin/adminauthor/edit";
	}
	
	@RequestMapping(value = "/author_edit", method = RequestMethod.POST)
	public String edit0(@ModelAttribute Author author0, Model model, HttpServletRequest request){
		List<Author> list0 = authorDao.listAll();
		Author a = null;
		for (Author author : list0) {
			if(author.getIDauthor().compareTo(author0.getIDauthor()) != 0 && author0.getAuthor().compareTo(author.getAuthor()) == 0) {
				model.addAttribute("error","Tác giả đã tồn tại");
				model.addAttribute("temp", author0);
				return "admin/adminauthor/edit";
			}
		}
		
		Date date = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");  
        String strDate = formatter.format(date);
        author0.setUpdated(strDate);
		authorDao.save(author0);
		model.addAttribute("temp", author0);
		model.addAttribute("error","Thành công cập nhật tác giả");
		return "admin/adminauthor/edit";
	}
	
	@RequestMapping("/deleteauthor/{IDauthor}")
	public String deleteauthor(@PathVariable(name = "IDauthor") Long IDauthor) {
		authorDao.delete(IDauthor);
		return "redirect:/admin/author";
	}
}
