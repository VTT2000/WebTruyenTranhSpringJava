package vn.holotruyentranh.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;     
import org.springframework.web.bind.annotation.RequestMapping;    


import vn.holotruyentranh.dao.CatergoryDao;
import vn.holotruyentranh.dao.ComicDao;    


@Controller
@RequestMapping("/home/")
public class HomeController {
	@Autowired
	private CatergoryDao catergoryDao;
	@Autowired
	private ComicDao comicDao;
	@RequestMapping("index")
	public String Index(Model model, HttpServletRequest request) {
		String message = "<h1>Hello World</h1>";
		model.addAttribute("message", message);
		model.addAttribute("go", catergoryDao.findAll().get(0).getCreated_at());
		model.addAttribute("go0", catergoryDao.findAll().get(0).getUpdate_at());
		model.addAttribute("cate", catergoryDao.findAll().get(0).getCatergory());
		model.addAttribute("cate0", catergoryDao.findAll().get(0).getDescription());
		model.addAttribute("listCatergory", catergoryDao.findAll());
		model.addAttribute("listComic", comicDao.findAll());
		return "home/index";
	}
}
 