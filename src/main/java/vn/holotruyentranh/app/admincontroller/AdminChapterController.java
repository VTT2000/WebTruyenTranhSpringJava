package vn.holotruyentranh.app.admincontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.holotruyentranh.app.bean.Chapter;
import vn.holotruyentranh.app.service.ChapterService;

@Controller
@RequestMapping("/admin/")
public class AdminChapterController {
	@Autowired
	private ChapterService ChapterDao;
	@RequestMapping("chapter")
	public String index(Model model) {
		List<Chapter> listChapters = ChapterDao.listAll();
		model.addAttribute("listChapters", listChapters);
		return "admin/adminchapter/chapter";
	}
	@RequestMapping("chapter_insert")
	public String insert(){	
		return "admin/adminchapter/insert";
	}
	
	@RequestMapping("chapter_edit")
	public String edit(){	
		return "admin/adminchapter/edit";
	}
}
