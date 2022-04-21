package vn.holotruyentranh.app.admincontroller;

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
import vn.holotruyentranh.app.bean.ComicCatergory;
import vn.holotruyentranh.app.service.ComicCatergoryService;

@Controller
@RequestMapping("/admin")
public class AdminComicCatergoryController {

	@Autowired
	private ComicCatergoryService comiccartDao;
	@RequestMapping("/comiccatergory")
	public String index(Model model, HttpSession session, HttpServletRequest request){
		return listByPage(model, 1, session, request);
	}
	@RequestMapping("/comiccatergory_{pageNum}")
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
		
		Page<ComicCatergory> page = comiccartDao.listAll(currentPage);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		List<ComicCatergory> list = page.getContent();
		
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("listComicCatergorys", list);
		
		return "admin/admincomiccart/comiccatergory";
	}

	@RequestMapping(value = "/comiccatergory_insert", method = RequestMethod.GET)
	public String insert(Model model){	
		model.addAttribute("error","");
		return "admin/admincomiccart/insert";
	}
	
	@RequestMapping(value = "/comiccatergory_insert", method = RequestMethod.POST)
	public String insert0(@ModelAttribute ComicCatergory comiccatergory0, Model model, HttpServletRequest request){
     
		comiccartDao.save(comiccatergory0);
		model.addAttribute("error","Thành công thêm");
		return "admin/admincomiccart/insert";
	}
	
	@RequestMapping(value = "/comiccatergory_edit", method = RequestMethod.GET)
	public String edit(Model model, HttpServletRequest request){
		Long idLong = Long.parseLong(request.getParameter("id"));
		ComicCatergory aComicCatergory = comiccartDao.get(idLong);
		model.addAttribute("temp", aComicCatergory);
		model.addAttribute("error","");
		return "admin/admincomiccart/edit";
	}
	
	@RequestMapping(value = "/comiccatergory_edit", method = RequestMethod.POST)
	public String edit0(@ModelAttribute ComicCatergory comiccatergory0, Model model, HttpServletRequest request){
		
		comiccartDao.save(comiccatergory0);
		model.addAttribute("temp", comiccatergory0);
		model.addAttribute("error","Thành công cập nhật");
		return "admin/admincomiccart/edit";
	}
	
	@RequestMapping("/deletecomicatergory/{id}")
	public String deletecomicatergory(@PathVariable(name = "id") Long id) {
		comiccartDao.delete(id);
		return "redirect:/admin/comiccatergory";
	}
}
