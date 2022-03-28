package vn.holotruyentranh.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;     
import org.springframework.web.bind.annotation.RequestMapping;


import vn.holotruyentranh.beans.Comic;
import vn.holotruyentranh.dao.ComicDao;    


@Controller
@RequestMapping("/home/")
public class HomeController {
	@Autowired
	private ComicDao comicDao;
	@RequestMapping("index")
	public String Index(Model model, HttpServletRequest request) {
		List<Comic> listComics = comicDao.findAll();
		Collections.sort(listComics, new Comparator<Comic>() {
			@Override
			public int compare(Comic o1, Comic o2) {
				// TODO Auto-generated method stub
				String ngay1 = o1.getUpdated();
				String ngay2 = o2.getUpdated();
				Date ngay10 = new Date(Integer.parseInt(ngay1.substring(0, 4)), Integer.parseInt(ngay1.substring(5,7)), Integer.parseInt(ngay1.substring(8,10)));
				Date ngay20 = new Date(Integer.parseInt(ngay2.substring(0, 4)), Integer.parseInt(ngay2.substring(5,7)), Integer.parseInt(ngay2.substring(8,10)));
				return ngay20.compareTo(ngay10);
			}
		});
		model.addAttribute("listComics", listComics.subList(0, 8));
		return "home/home";
	}
}
 