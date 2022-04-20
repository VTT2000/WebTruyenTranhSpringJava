package vn.holotruyentranh.app.admincontroller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.holotruyentranh.app.bean.Catergory;
import vn.holotruyentranh.app.service.CatergoryService;

@Controller
@RequestMapping("/admin/")
public class AdminCategoryController {
	@Autowired
	private CatergoryService CatergoryDao;
	@RequestMapping("category")
	public String index(Model model) {
		List<Catergory> listCatergorys = CatergoryDao.listAll();
		model.addAttribute("listCatergorys", listCatergorys);
		return "admin/admincategory/category";
	}
	
	@RequestMapping(value = "category_insert", method = RequestMethod.GET)
	public String insert(Model model){	
		model.addAttribute("error","");
		return "admin/admincategory/insert";
	}
	
	@RequestMapping(value = "category_insert", method = RequestMethod.POST)
	public String insert0(@ModelAttribute Catergory catergory0, Model model, HttpServletRequest request){
		List<Catergory> list0 = CatergoryDao.listAll();
		Catergory a = null;
		for (Catergory catergory : list0) {
			if(catergory0.getCatergory().compareTo(catergory.getCatergory()) == 0) {
				model.addAttribute("error","Thể loại đã tồn tại");
				return "admin/admincategory/insert"; 
			}
		}
		Date date = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");  
        String strDate = formatter.format(date);
        catergory0.setCreated_at(strDate);
        catergory0.setUpdate_at(strDate);
     
		CatergoryDao.save(catergory0);
		model.addAttribute("error","Thành công thêm thể loại");
		return "admin/admincategory/insert";
	}
	
	@RequestMapping(value = "category_edit", method = RequestMethod.GET)
	public String edit(Model model, HttpServletRequest request){
		Long idLong = Long.parseLong(request.getParameter("id"));
		Catergory aCatergory = CatergoryDao.get(idLong);
		model.addAttribute("temp", aCatergory);
		model.addAttribute("error","");
		return "admin/admincategory/edit";
	}
	
	@RequestMapping(value = "category_edit", method = RequestMethod.POST)
	public String edit0(@ModelAttribute Catergory catergory0, Model model, HttpServletRequest request){
		List<Catergory> list0 = CatergoryDao.listAll();
		Catergory a = null;
		for (Catergory catergory : list0) {
			if(catergory.getIDcatergory().compareTo(catergory0.getIDcatergory()) != 0 && catergory0.getCatergory().compareTo(catergory.getCatergory()) == 0) {
				model.addAttribute("error","Thể loại đã tồn tại");
				model.addAttribute("temp", catergory0);
				return "admin/admincategory/edit";
			}
		}
		
		Date date = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");  
        String strDate = formatter.format(date);
        catergory0.setUpdate_at(strDate);
		CatergoryDao.save(catergory0);
		model.addAttribute("temp", catergory0);
		model.addAttribute("error","Thành công cập nhật thể loại");
		return "admin/admincategory/edit";
	}
	
}
