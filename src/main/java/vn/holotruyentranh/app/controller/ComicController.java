package vn.holotruyentranh.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import vn.holotruyentranh.app.bean.ImageChapter;
import vn.holotruyentranh.app.bean.TheoDoi;
import vn.holotruyentranh.app.service.AuthorService;
import vn.holotruyentranh.app.service.CatergoryService;
import vn.holotruyentranh.app.service.ChapterService;
import vn.holotruyentranh.app.service.ComicCatergoryService;
import vn.holotruyentranh.app.service.ComicService;
import vn.holotruyentranh.app.service.ImageChapterService;
import vn.holotruyentranh.app.service.TheoDoiService;    

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
	@Autowired
	private ImageChapterService imageChapterService;
	@Autowired
	private TheoDoiService theoDoiService;
	@RequestMapping(value = "Index", method = RequestMethod.GET)
	public String Index(Model model, HttpServletRequest request, HttpSession session) {
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
		
		String Follow = "Lưu";
		Long IDcomic = Long.parseLong(request.getParameter("IDcomic"));
		Long IDuser = (Long)session.getAttribute("KhachHangIdKH");
		List<TheoDoi> list = theoDoiService.listAll();
		for (TheoDoi theoDoi : list) {
			if(theoDoi.getIDcomic() == IDcomic && theoDoi.getIDuser() == IDuser) {
				Follow = "Bỏ Lưu";
			}
		}
		model.addAttribute("theodoi", Follow);
		model.addAttribute("chapters", chapters);
		model.addAttribute("author", author);
		model.addAttribute("catergorys", catergorys);
		model.addAttribute("comic", comic);
		
		// luu lich su
		List<Comic> historyComics = new ArrayList<Comic>();
		if(session.getAttribute("history"+session.getAttribute("KhachHangIdKH")) == null) {
			historyComics.add(comic);
			session.setAttribute("history"+session.getAttribute("KhachHangIdKH"), historyComics);
		}
		else {
			historyComics = (List<Comic>) session.getAttribute("history"+session.getAttribute("KhachHangIdKH"));
			for (Comic comic2 : historyComics) {
				if(comic2.getIDcomic() == id) {
					return "comic/comic";
				}
			}
			historyComics.add(comic);
			session.setAttribute("history"+session.getAttribute("KhachHangIdKH"), historyComics);
		}
		
		return "comic/comic";
	}
	
	@RequestMapping(value = "Chapter", method = RequestMethod.GET)
	public String Chapter(Model model, HttpServletRequest request) {
		Long IDcomic = Long.parseLong(request.getParameter("IDcomic"));
		Long IDchapter = Long.parseLong(request.getParameter("IDchapter"));
		Chapter chapter = chapterDao.get(IDchapter);
		Chapter previousChapter = chapterDao.getChapterPrevious(IDcomic, IDchapter);
		Chapter nextChapter = chapterDao.getChapterNexts(IDcomic, IDchapter);
		List<ImageChapter> list = imageChapterService.getByIDchapter(IDchapter);
		List<Chapter> list1 = chapterDao.getByIDcomic(IDcomic);
		
		model.addAttribute("previous", previousChapter);
		model.addAttribute("nexts", nextChapter);
		model.addAttribute("chapter", chapter);
		model.addAttribute("IDcomic", IDcomic);
		model.addAttribute("listImage", list);
		model.addAttribute("chapters", list1);
		return "comic/chapter";
	}
	
	@RequestMapping(value = "AllComic", method = RequestMethod.GET)
	public String AllComic(Model model, HttpServletRequest request) {
		Long IDcatergory;	
		if(request.getParameter("IDcatergory").isEmpty()) {
			IDcatergory = Long.parseLong("1");
		}
		else {
			IDcatergory = Long.parseLong(request.getParameter("IDcatergory"));
		}
		
		List<ComicCatergory> list5 = (List<ComicCatergory>)comicCatergoryDao.getByIDcatergory(IDcatergory);
		List<Long> list6 = new ArrayList<Long>();
		for (ComicCatergory comicCatergory : list5) {
			if(comicCatergory.getIDcatergory() == IDcatergory) {
				list6.add(comicCatergory.getIDcomic());
			}
		}
		
		List<Comic> list7 = (List<Comic>)comicDao.listAll();
		List<Comic> list8 = new ArrayList<Comic>();
		for (Comic comic : list7) {
			if(list6.contains(comic.getIDcomic())) {
				list8.add(comic);
			}
		}
		
		List<Catergory> list0 = catergoryDao.listAll();
		
		model.addAttribute("comics", list8);
		model.addAttribute("catergorys", list0);
		model.addAttribute("IDcatergory", IDcatergory);
		System.out.print("comic1: "+list6.size());
		System.out.print("comic2: "+list8.size());
		System.out.print("catergory: "+list0.size());
		System.out.print("catergoryID: "+IDcatergory);
		return "comic/allcomic";
	}
	
	@RequestMapping(value = "TheoDoi", method = RequestMethod.GET)
	public String TheoDoiComic(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		Long IDcomic = Long.parseLong(request.getParameter("IDcomic"));
		Long IDuser = (Long)session.getAttribute("KhachHangIdKH");
		List<TheoDoi> list = theoDoiService.listAll();
		for (TheoDoi theoDoi : list) {
			if(theoDoi.getIDcomic() == IDcomic && theoDoi.getIDuser() == IDuser) {
				theoDoiService.delete(theoDoi.getId());
				return "redirect:/Comic/Index?IDcomic="+IDcomic;
			}
		}
		TheoDoi temp = new TheoDoi();
		temp.setIDcomic(IDcomic);
		temp.setIDuser(IDuser);
		theoDoiService.save(temp);
		return "redirect:/Comic/Index?IDcomic="+IDcomic;
	}
	
	
}
 