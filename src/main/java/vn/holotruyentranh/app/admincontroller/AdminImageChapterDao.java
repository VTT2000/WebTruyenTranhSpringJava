package vn.holotruyentranh.app.admincontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.holotruyentranh.app.bean.ImageChapter;
import vn.holotruyentranh.app.service.ImageChapterService;

@Controller
@RequestMapping("/admin/")
public class AdminImageChapterDao {
	@Autowired
	private ImageChapterService ImageChapterDao;
	@RequestMapping("imagechapter")
	public String index(Model model) {
		List<ImageChapter> listImageChapters = ImageChapterDao.listAll();
		model.addAttribute("listImageChapters", listImageChapters);
		return "admin/adminimage/imagechapter";
	}
	@RequestMapping("image_insert")
	public String insert(){	
		return "admin/adminimage/insert";
	}
	
	@RequestMapping("image_edit")
	public String edit(){	
		return "admin/adminimage/edit";
	}
}
