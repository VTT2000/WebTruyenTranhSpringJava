package vn.holotruyentranh.app.admincontroller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.holotruyentranh.app.bean.*;
import vn.holotruyentranh.app.service.*;



@Controller
@RequestMapping("/admin/")
public class OldAdminController {

	@Autowired
	private ComicService comicDao;
	@Autowired
	private AuthorService authorDao;
	@Autowired
	private CatergoryService CatergoryDao;
	@Autowired
	private ChapterService ChapterDao;
	@Autowired
	private TransTeamService TransteamDao;
	@Autowired
	private ImageChapterService ImageChapterDao;
	@Autowired
	private UserService UserDao;
	
	@RequestMapping("comics")
	public String comics(Model model) {
		List<Comic> listComics = comicDao.listAll();
		model.addAttribute("listComics", listComics);
		return "admin/comic";
	}
	@RequestMapping("/admn/newcomics")
	public String newcomics(Model model) {
		Comic c = new Comic();
		model.addAttribute("comic", c);
		return "admin/newcomic";
	}
	@RequestMapping(value = "/admin/savecomics", method = RequestMethod.POST)
	public String savecomics(@ModelAttribute("comic") Comic comic) {
		comicDao.save(comic);
		return "admin/comic";
	}
	@RequestMapping("/admin/delete/{IDcomic}")
	public String deletecomic(@PathVariable(name = "IDcomic") Long IDcomic) {
		comicDao.delete(IDcomic);
		return "admin/comic";
	}
	@RequestMapping("/edit/{IDcomic}")
	public ModelAndView editcomic(@PathVariable(name = "IDcomic") Long IDcomic) {
		ModelAndView mav = new ModelAndView("/admin/editcomic");
		Comic c = comicDao.get(IDcomic);
		mav.addObject("comic",c);
		return mav;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------
	@RequestMapping("authors")
	public String authors(Model model) {
		List<Author> listAuthors = authorDao.listAll();
		model.addAttribute("listAuthors", listAuthors);
		return "admin/author";
	}
	
	@RequestMapping("categorys")
	public String categorys(Model model) {
		List<Catergory> listCatergorys = CatergoryDao.listAll();
		model.addAttribute("listCatergorys", listCatergorys);
		return "admin/category";
	}
	
	@RequestMapping("transteams")
	public String transteams(Model model) {
		List<TransTeam> listTransTeams = TransteamDao.listAll();
		model.addAttribute("listTransTeams", listTransTeams);
		return "admin/transteam";
	}
	
	@RequestMapping("chapters")
	public String chapters(Model model) {
		List<Chapter> listChapters = ChapterDao.listAll();
		model.addAttribute("listChapters", listChapters);
		return "admin/chapter";
	}
	
	@RequestMapping("imagechapters")
	public String imagechapters(Model model) {
		List<ImageChapter> listImageChapters = ImageChapterDao.listAll();
		model.addAttribute("listImageChapters", listImageChapters);
		return "admin/imagechapter";
	}
	
	@RequestMapping("users")
	public String users(Model model) {
		List<User> listUsers = UserDao.listAll();
		model.addAttribute("listUsers", listUsers);
		return "admin/user";
	}	
}
