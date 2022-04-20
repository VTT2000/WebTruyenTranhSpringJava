package vn.holotruyentranh.app.admincontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.holotruyentranh.app.bean.Author;

import vn.holotruyentranh.app.service.AuthorService;

@Controller
@RequestMapping("/admin/")
public class AdminAuthorController {
	@Autowired
	private AuthorService authorDao;
	@RequestMapping("author")
	public String index(Model model){
		List<Author> listAuthors = authorDao.listAll();
		model.addAttribute("listAuthors", listAuthors);
		return "admin/adminauthor/author";
	}
	@RequestMapping("author_insert")
	public String insert(){	
		return "admin/adminauthor/insert";
	}
	
	@RequestMapping("author_edit")
	public String edit(){	
		return "admin/adminauthor/edit";
	}
}
