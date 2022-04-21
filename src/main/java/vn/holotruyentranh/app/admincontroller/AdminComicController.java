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

import vn.holotruyentranh.app.bean.Chapter;
import vn.holotruyentranh.app.bean.Comic;
import vn.holotruyentranh.app.service.ComicService;

@Controller
@RequestMapping("/admin")
public class AdminComicController {

	@Autowired
	private ComicService comicDao;
	@RequestMapping("/comic")
	public String index(Model model, HttpSession session, HttpServletRequest request){
		return listByPage(model, 1, session, request);
	}
	@RequestMapping("/comic_{pageNum}")
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
		Page<Comic> page = comicDao.listAll(currentPage);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		List<Comic> list = page.getContent();
		
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("listComics", list);
		
		return "admin/admincomic/comic";
	}
	@RequestMapping(value = "/comic_insert", method = RequestMethod.GET)
	public String insert(Model model){	
		model.addAttribute("error","");
		return "admin/admincomic/insert";
	}
	
	@RequestMapping(value = "/comic_insert", method = RequestMethod.POST)
	public String insert0(@ModelAttribute Comic comic0, Model model, HttpServletRequest request){
		List<Comic> list0 = comicDao.listAll();
		Comic a = null;
		for (Comic comic : list0) {
			if(comic0.getComic().compareTo(comic.getComic()) == 0) {
				model.addAttribute("error","truyên đã tồn tại");
				return "admin/admincomic/insert"; 
			}
		}
		Date date = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");  
        String strDate = formatter.format(date);
        comic0.setCreated(strDate);
        comic0.setUpdated(strDate);
     
		comicDao.save(comic0);
		model.addAttribute("error","Thành công thêm truyên");
		return "admin/admincomic/insert";
	}
	
	@RequestMapping(value = "/comic_edit", method = RequestMethod.GET)
	public String edit(Model model, HttpServletRequest request){
		Long idLong = Long.parseLong(request.getParameter("id"));
		Comic aComic = comicDao.get(idLong);
		model.addAttribute("temp", aComic);
		model.addAttribute("error","");
		return "admin/admincomic/edit";
	}
	
	@RequestMapping(value = "/comic_edit", method = RequestMethod.POST)
	public String edit0(@ModelAttribute Comic comic0, Model model, HttpServletRequest request){
		List<Comic> list0 = comicDao.listAll();
		Comic a = null;
		for (Comic comic : list0) {
			if(comic.getIDcomic().compareTo(comic0.getIDcomic()) != 0 && comic0.getComic().compareTo(comic.getComic()) == 0) {
				model.addAttribute("error","truyên đã tồn tại");
				model.addAttribute("temp", comic0);
				return "admin/admincomic/edit";
			}
		}
		
		Date date = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");  
        String strDate = formatter.format(date);
        comic0.setUpdated(strDate);
		comicDao.save(comic0);
		model.addAttribute("temp", comic0);
		model.addAttribute("error","Thành công cập nhật truyên");
		return "admin/admincomic/edit";
	}
	
	@RequestMapping("/deletecomic/{IDcomic}")
	public String deletecomic(@PathVariable(name = "IDcomic") Long IDcomic) {
		comicDao.delete(IDcomic);
		return "redirect:/admin/comic";
	}
}


