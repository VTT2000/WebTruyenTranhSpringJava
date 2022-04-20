package vn.holotruyentranh.app.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.holotruyentranh.app.bean.Comic;
import vn.holotruyentranh.app.bean.TheoDoi;
import vn.holotruyentranh.app.bean.User;
import vn.holotruyentranh.app.service.ComicService;
import vn.holotruyentranh.app.service.TheoDoiService;
import vn.holotruyentranh.app.service.UserService;

@Controller
@RequestMapping("/User")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private TheoDoiService theoDoiService;
	@Autowired
	private ComicService comicService;
	@RequestMapping("/Info")
	public String Info(Model model, HttpServletRequest request, HttpSession session) {
		Long idKHLong = (Long)session.getAttribute("KhachHangIdKH");
		User info = userService.get(idKHLong);
		
		model.addAttribute("user", info);
		return "user/info";
	}
	
	@RequestMapping("/LogOut")
	public String LogOut(Model model, HttpServletRequest request, HttpSession session, HttpServletResponse response) {
		session.setAttribute("history"+session.getAttribute("KhachHangIdKH"), null);
		session.setAttribute("KhachHangIdKH", null);
		session.setAttribute("KhachHangName", null);
		
		Cookie cookie = null;
        Cookie[] cookies = null;
        cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            cookie = cookies[i];
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
		return "redirect:/home/index";
	}
	
	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("user")User upUser, Model model, HttpServletRequest request, HttpSession session) {
		Long idKHLong = (Long)session.getAttribute("KhachHangIdKH");
		User temp = userService.get(idKHLong);
		temp.setUsername(upUser.getUsername());
		temp.setPassword(upUser.getPassword());
		temp.setMail(upUser.getMail());
		Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");  
        String strDate = formatter.format(date);
		temp.setUpdated(strDate);
		
		session.setAttribute("KhachHangName", temp.getUsername());
		userService.save(temp);
		return "redirect:/User/Info";
	}
	
	@RequestMapping(value = "/TheoDoi", method = RequestMethod.GET)
	public String TheoDoi000(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		Long IDuser = (Long)session.getAttribute("KhachHangIdKH");
		List<TheoDoi> list0 = theoDoiService.listAll();
		List<Long> list1 = new ArrayList<Long>();
		for (TheoDoi theoDoi : list0) {
			if(theoDoi.getIDuser() == IDuser) {
				list1.add(theoDoi.getIDcomic());
			}
		}
		List<Comic> list3 = comicService.listAll();
		List<Comic> list4 = new ArrayList<Comic>();
		for (Comic comic : list3) {
			if(list1.contains(comic.getIDcomic())) {
				list4.add(comic);
			}
		}
		
		model.addAttribute("comics", list4);
		
		return "user/savecomic";
	}
	
	@RequestMapping(value = "BoTheoDoi", method = RequestMethod.GET)
	public String TheoDoiComic(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		Long IDcomic = Long.parseLong(request.getParameter("IDcomic"));
		Long IDuser = (Long)session.getAttribute("KhachHangIdKH");
		List<TheoDoi> list = theoDoiService.listAll();
		for (TheoDoi theoDoi : list) {
			if(theoDoi.getIDcomic() == IDcomic && theoDoi.getIDuser() == IDuser) {
				theoDoiService.delete(theoDoi.getId());
			}
		}
		return "redirect:/User/TheoDoi";
	}
	
	@RequestMapping(value = "/ComicHistory", method = RequestMethod.GET)
	public String TheoDoi00(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// lay list comic trong session
		List<Comic> historyComics = new ArrayList<Comic>();
		if(session.getAttribute("history"+session.getAttribute("KhachHangIdKH")) != null) {
			historyComics = (List<Comic>) session.getAttribute("history"+session.getAttribute("KhachHangIdKH"));
		}
		model.addAttribute("comics", historyComics);
		return "user/history";
	}
	
}
