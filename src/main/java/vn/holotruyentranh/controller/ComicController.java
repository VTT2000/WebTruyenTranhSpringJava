package vn.holotruyentranh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;     
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.holotruyentranh.beans.Author;
import vn.holotruyentranh.beans.Catergory;
import vn.holotruyentranh.beans.Chapter;
import vn.holotruyentranh.beans.Comic;
import vn.holotruyentranh.beans.ComicCatergory;
import vn.holotruyentranh.dao.AuthorDao;
import vn.holotruyentranh.dao.CatergoryDao;
import vn.holotruyentranh.dao.ChapterDao;
import vn.holotruyentranh.dao.ComicCatergoryDao;
import vn.holotruyentranh.dao.ComicDao;    


@Controller
@RequestMapping("/Comic/")
public class ComicController {
	@Autowired
	private ComicDao comicDao;
	@Autowired
	private ComicCatergoryDao comicCatergoryDao;
	@Autowired
	private CatergoryDao catergoryDao;
	@Autowired
	private AuthorDao authorDao;
	@Autowired
	private ChapterDao chapterDao;
	@RequestMapping(value = "Index", method = RequestMethod.GET)
	public String Index(Model model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("IDcomic"));
		Comic comic = comicDao.findOne(id);
		List<ComicCatergory> list0 = comicCatergoryDao.find(0, comic.getIDcomic());
		List<Catergory> catergorys = new ArrayList<Catergory>();
		for (int i = 0; i < list0.size(); i++) {
			Catergory temp = catergoryDao.findOne(list0.get(i).getIDcatergory());
			catergorys.add(temp);
		}
		Author author = authorDao.findOne(comic.getIDauthor());
		List<Chapter> chapters = new ArrayList<Chapter>();
		List<Chapter> list1 = chapterDao.findAll();
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
 