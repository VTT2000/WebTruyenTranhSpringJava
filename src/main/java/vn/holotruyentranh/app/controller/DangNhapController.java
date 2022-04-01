package vn.holotruyentranh.app.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.holotruyentranh.app.service.UserService;
import vn.holotruyentranh.app.bean.User;
import vn.holotruyentranh.app.object.DangNhap;



@RestController
public class DangNhapController {
	@Autowired
	private UserService userDao;
	@PostMapping(value = "/api/DangNhapKH", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String Login(
			@RequestBody DangNhap taiKhoan, 
			HttpServletRequest request, 
			HttpServletResponse response) {
        String phanHoi = "";
        List<User> list = userDao.listAll();
        User kh = null;
        for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getMail().compareTo(taiKhoan.getEmail()) == 0) {
				kh = list.get(i);
				break;
			}
		}
        if (kh == null)
        {
            phanHoi = "Tài khoản không tồn tại";
        }
        else
        {
        	if(kh.getPassword().compareTo(taiKhoan.getPass()) == 0) {
        		request.getSession().setAttribute("KhachHangName", kh.getUsername());
            	request.getSession().setAttribute("KhachHangIdKH", kh.getIDuser());
            	if (taiKhoan.isRemember()) {
            		Cookie cook1 = new Cookie("KhachHangIdKH", String.valueOf(kh.getIDuser()) ); //bake cookie
                    Cookie cook2 = new Cookie("KhachHangName", kh.getUsername()); //bake cookie
                    cook1.setMaxAge(60*60*2); //set expire time 60*60*2 = 2h
                    cook2.setMaxAge(60*60*2);
                    response.addCookie(cook1); //put cookie in response 
                    response.addCookie(cook2);
            	}
            	phanHoi = "OK";
        	}
        	else {
        		phanHoi = "Sai mật khẩu";
			}
        }
        return phanHoi;
	}
	
	/*
	@GetMapping("/employees")
	String all() {
		return "10";
	}
	// end::get-aggregate-root[]
	*/
}
