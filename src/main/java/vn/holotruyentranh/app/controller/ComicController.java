package vn.holotruyentranh.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;     
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.holotruyentranh.app.bean.Author;
import vn.holotruyentranh.app.bean.Catergory;
import vn.holotruyentranh.app.bean.Chapter;
import vn.holotruyentranh.app.bean.Comic;
import vn.holotruyentranh.app.bean.ComicCatergory;
import vn.holotruyentranh.app.service.AuthorService;
import vn.holotruyentranh.app.service.CatergoryService;
import vn.holotruyentranh.app.service.ChapterService;
import vn.holotruyentranh.app.service.ComicCatergoryService;
import vn.holotruyentranh.app.service.ComicService;    


@Controller
@RequestMapping("/Comic/")
public class ComicController {
	@Autowired
	private ComicService comicDao;
	@Autowired
	private ComicCatergoryService comicCatergoryDao;
	@Autowired
	private CatergoryService catergoryDao;
	@Autowired
	private AuthorService authorDao;
	@Autowired
	private ChapterService chapterDao;
	@RequestMapping(value = "Index", method = RequestMethod.GET)
	public String Index(Model model, HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("IDcomic"));
		Comic comic = comicDao.get(id);
		List<ComicCatergory> list0 = comicCatergoryDao.getByIDcomic(comic.getIDcomic());
		List<Catergory> catergorys = new ArrayList<Catergory>();
		for (int i = 0; i < list0.size(); i++) {
			Catergory temp = catergoryDao.get(list0.get(i).getIDcatergory());
			catergorys.add(temp);
		}
		Author author = authorDao.get(comic.getIDauthor());
		List<Chapter> chapters = new ArrayList<Chapter>();
		List<Chapter> list1 = chapterDao.listAll();
		for (int i = 0; i < list1.size(); i++) {
			if(list1.get(i).getIDcomic() == comic.getIDcomic()) {
				chapters.add(list1.get(i));
			}
		}
		
		model.addAttribute("chapters", chapters);
		model.addAttribute("catergorys", catergorys);
		model.addAttribute("author", author);
		model.addAttribute("comic", comic);
		return "comic/comic";
	}
}
 