package vn.holotruyentranh.app.admincontroller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import vn.holotruyentranh.app.bean.User;
import vn.holotruyentranh.app.object.DangNhap;
import vn.holotruyentranh.app.service.UserService;



@Controller
@RequestMapping(value="/admin/")
public class AdminController {
	@Autowired
	private UserService userService;
	/*
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login( ModelMap mm ) {
		mm.put("tk", new UserService());
		return "admin/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute(value = "tk") UserService tk ,ModelMap mm ) {
		
		return "admin/login";
	}
	*/
	@RequestMapping(value = "/index")
	public String index(HttpSession session, HttpServletRequest request){
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
		
		return "admin/index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model){
		model.addAttribute("error", "");
		model.addAttribute("mail", "");
		model.addAttribute("pass", "");
		model.addAttribute("check", false);
		return "admin/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login0(@ModelAttribute("taiKhoan")DangNhap taiKhoan, Model model, HttpServletRequest request, HttpSession session, HttpServletResponse response)
	{
		List<User> list0 = userService.listAll();
		User a = null;
		for (User user : list0) {
			if(user.getMail().compareTo(taiKhoan.getEmail()) == 0) {
				a = user;
				break;
			}
		}
		if(a == null) {
			model.addAttribute("error", "Tài khoản không tồn tại");
			model.addAttribute("mail", taiKhoan.getEmail());
			model.addAttribute("pass", taiKhoan.getPass());
			model.addAttribute("check", taiKhoan.isRemember());
			return "admin/login";
		}
		if(a.getPassword().compareTo(taiKhoan.getPass()) != 0) {
			model.addAttribute("error", "Sai mật khẩu");
			model.addAttribute("mail", taiKhoan.getEmail());
			model.addAttribute("pass", taiKhoan.getPass());
			model.addAttribute("check", taiKhoan.isRemember());
			return "admin/login";	
		}
		if(a.getIDper().compareTo(Long.parseLong("2")) != 0) {
			model.addAttribute("error", "Bạn không phải quản trị");
			model.addAttribute("mail", taiKhoan.getEmail());
			model.addAttribute("pass", taiKhoan.getPass());
			model.addAttribute("check", taiKhoan.isRemember());
			return "admin/login";
		}
		
		session.setAttribute("AdminName", a.getUsername());
		session.setAttribute("AdminIdKH", a.getIDuser());
		
		if (taiKhoan.isRemember()) {
    		Cookie cook1 = new Cookie("AdminIdKH", String.valueOf(a.getIDuser()) ); //bake cookie
            Cookie cook2 = new Cookie("AdminName", a.getUsername()); //bake cookie
            cook1.setMaxAge(60*60*2); //set expire time 60*60*2 = 2h
            cook2.setMaxAge(60*60*2);
            response.addCookie(cook1); //put cookie in response 
            response.addCookie(cook2);
    	}
		
		return "redirect:/admin/index";
	}
	
	@RequestMapping("/logout")
	public String logout(Model model, HttpServletRequest request, HttpSession session, HttpServletResponse response) {
		session.setAttribute("AdminIdKH", null);
		session.setAttribute("AdminName", null);
		
		Cookie cookie = null;
        Cookie[] cookies = null;
        cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            cookie = cookies[i];
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
		return "redirect:/admin/login";
	}
}
