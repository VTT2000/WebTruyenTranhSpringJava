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

import vn.holotruyentranh.app.bean.Catergory;
import vn.holotruyentranh.app.bean.Chapter;
import vn.holotruyentranh.app.service.ChapterService;

@Controller
@RequestMapping("/admin")
public class AdminChapterController {
	@Autowired
	private ChapterService ChapterDao;
	@RequestMapping("/chapter")
	public String index(Model model, HttpSession session, HttpServletRequest request){
		return listByPage(model, 1, session, request);
	}
	
	@RequestMapping("/chapter_{pageNum}")
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
		
		Page<Chapter> page = ChapterDao.listAll(currentPage);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		List<Chapter> list = page.getContent();
		
		model.addAttribute("listChapters", list);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", currentPage);
		
		return "admin/adminchapter/chapter";
	}
	@RequestMapping(value = "/chapter_insert", method = RequestMethod.GET)
	public String insert(Model model){	
		model.addAttribute("error","");
		return "admin/adminchapter/insert";
	}
	
	@RequestMapping(value = "/chapter_insert", method = RequestMethod.POST)
	public String insert0(@ModelAttribute Chapter chapter0, Model model, HttpServletRequest request){
		List<Chapter> list0 = ChapterDao.listAll();
		Chapter a = null;
		for (Chapter chapter : list0) {
			if(chapter0.getChapter().compareTo(chapter.getChapter()) == 0) {
				model.addAttribute("error","đã tồn tại");
				return "admin/adminchapter/insert"; 
			}
		}
		Date date = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");  
        String strDate = formatter.format(date);
        chapter0.setCreated(strDate);
        chapter0.setUpdated(strDate);
     
		ChapterDao.save(chapter0);
		model.addAttribute("error","Thành công thêm");
		return "admin/adminchapter/insert";
	}
	
	@RequestMapping(value = "/chapter_edit", method = RequestMethod.GET)
	public String edit(Model model, HttpServletRequest request){
		Long idLong = Long.parseLong(request.getParameter("id"));
		Chapter aChapter = ChapterDao.get(idLong);
		model.addAttribute("temp", aChapter);
		model.addAttribute("error","");
		return "admin/adminchapter/edit";
	}
	
	@RequestMapping(value = "/chapter_edit", method = RequestMethod.POST)
	public String edit0(@ModelAttribute Chapter chapter0, Model model, HttpServletRequest request){
		List<Chapter> list0 = ChapterDao.listAll();
		Chapter a = null;
		for (Chapter chapter : list0) {
			if(chapter.getIDchapter().compareTo(chapter0.getIDchapter()) != 0 && chapter0.getChapter().compareTo(chapter.getChapter()) == 0) {
				model.addAttribute("error","đã tồn tại");
				model.addAttribute("temp", chapter0);
				return "admin/adminchapter/edit";
			}
		}
		
		Date date = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");  
        String strDate = formatter.format(date);
        chapter0.setUpdated(strDate);
		ChapterDao.save(chapter0);
		model.addAttribute("temp", chapter0);
		model.addAttribute("error","Thành công cập nhật");
		return "admin/adminchapter/edit";
	}
	
	@RequestMapping("/deletechapter/{IDchapter}")
	public String deletechapter(@PathVariable(name = "IDchapter") Long IDchapter) {
		ChapterDao.delete(IDchapter);
		return "redirect:/admin/chapter";
	}
}
