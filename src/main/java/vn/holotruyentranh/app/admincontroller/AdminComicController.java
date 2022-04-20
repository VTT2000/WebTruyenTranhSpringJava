package vn.holotruyentranh.app.admincontroller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;     
import org.springframework.web.bind.annotation.RequestMapping;
import vn.holotruyentranh.app.bean.Comic;
import vn.holotruyentranh.app.service.ComicService;

@Controller
@RequestMapping("/admin/")
public class AdminComicController {

	@Autowired
	private ComicService comicDao;
	@RequestMapping("comic")
	public String index(Model model){
		List<Comic> listComics = comicDao.listAll();
		model.addAttribute("listComics", listComics);
		return "admin/admincomic/comic";
	}
	@RequestMapping("comic_insert")
	public String insert(){	
		return "admin/admincomic/insert";
	}
	
	@RequestMapping("comic_edit")
	public String edit(){	
		return "admin/admincomic/edit";
	}
}


