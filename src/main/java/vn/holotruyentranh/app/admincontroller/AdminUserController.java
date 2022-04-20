package vn.holotruyentranh.app.admincontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.holotruyentranh.app.bean.User;
import vn.holotruyentranh.app.service.UserService;
@Controller
@RequestMapping("/admin/")
public class AdminUserController {
	@Autowired
	private UserService UserDao;
	@RequestMapping("user")
	public String index(Model model) {
		List<User> listUsers = UserDao.listAll();
		model.addAttribute("listUsers", listUsers);
		return "admin/adminuser/user";
	}
	@RequestMapping("user_insert")
	public String insert(){	
		return "admin/adminuser/insert";
	}
	
	@RequestMapping("user_edit")
	public String edit(){	
		return "admin/adminuser/edit";
	}
}
