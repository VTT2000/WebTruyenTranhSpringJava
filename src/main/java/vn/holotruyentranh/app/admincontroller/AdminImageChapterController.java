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
import vn.holotruyentranh.app.bean.ImageChapter;
import vn.holotruyentranh.app.service.ImageChapterService;

@Controller
@RequestMapping("/admin")
public class AdminImageChapterController {
	@Autowired
	private ImageChapterService ImageChapterDao;
	@RequestMapping("/imagechapter")
	public String index(Model model, HttpSession session, HttpServletRequest request){
		return listByPage(model, 1, session, request);
	}
	@RequestMapping("/imagechapter_{pageNum}")
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
		Page<ImageChapter> page = ImageChapterDao.listAll(currentPage);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		List<ImageChapter> list = page.getContent();
		
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("listImageChapters", list);
		return "admin/adminimage/imagechapter";
	}

	@RequestMapping(value = "/imagechapter_insert", method = RequestMethod.GET)
	public String insert(Model model){	
		model.addAttribute("error","");
		return "admin/adminimage/insert";
	}
	
	@RequestMapping(value = "/imagechapter_insert", method = RequestMethod.POST)
	public String insert0(@ModelAttribute ImageChapter imagechapter0, Model model, HttpServletRequest request){
     
		ImageChapterDao.save(imagechapter0);
		model.addAttribute("error","Thành công thêm thể loại");
		return "admin/adminimage/insert";
	}
	
	@RequestMapping(value = "/imagechapter_edit", method = RequestMethod.GET)
	public String edit(Model model, HttpServletRequest request){
		Long idLong = Long.parseLong(request.getParameter("id"));
		ImageChapter aImageChapter = ImageChapterDao.get(idLong);
		model.addAttribute("temp", aImageChapter);
		model.addAttribute("error","");
		return "admin/adminimage/edit";
	}
	
	@RequestMapping(value = "/imagechapter_edit", method = RequestMethod.POST)
	public String edit0(@ModelAttribute ImageChapter imagechapter0, Model model, HttpServletRequest request){
		
		ImageChapterDao.save(imagechapter0);
		model.addAttribute("temp", imagechapter0);
		model.addAttribute("error","Thành công cập nhật thể loại");
		return "admin/adminimage/edit";
	}
	
	@RequestMapping("/deleteimage/{IdImageChapter}")
	public String deleteimage(@PathVariable(name = "IdImageChapter") Long IdImageChapter) {
		ImageChapterDao.delete(IdImageChapter);
		return "redirect:/admin/imagechapter";
	}
}
