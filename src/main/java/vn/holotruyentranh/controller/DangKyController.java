package vn.holotruyentranh.controller;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.holotruyentranh.beans.User;
import vn.holotruyentranh.dao.UserDao;
import vn.holotruyentranh.object.DangKy;

@RestController
public class DangKyController {
	
	@Autowired
	private UserDao userDao;
	@PostMapping(value = "/api/DangKyKH", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String Login(@RequestBody DangKy khachHang) {
		List<User> list = userDao.findAll();
		User findKH = null;
        for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getMail().compareTo(khachHang.getEmail()) == 0) {
				findKH = list.get(i);
				break;
			}
		}
        if(findKH == null)
        {
            if(khachHang.getPassword().length() >= 6)
            {
            	User temp = new User();
            	Date date = new Date();  
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");  
                String strDate = formatter.format(date);  
            	temp.setCreated(strDate);
            	temp.setUpdated(strDate);
            	temp.setUsername(khachHang.getName());
            	temp.setMail(khachHang.getEmail());
            	temp.setPassword(khachHang.getPassword());
            	temp.setIDper(1);
            	userDao.save(temp);
                return "OK";
            }
            else
            {
                return "Password tối thiểu 6 kí tự";
            }
            
        }
        else
        {
            return "Email đã được đăng ký, bạn hãy nhập Email khác";
        }
	}
	/*
	@PostMapping(value = "/api/DangKyKH", consumes = MediaType.APPLICATION_JSON_VALUE)
	String all(@RequestBody DangKy khachHang) {
		return khachHang.getEmail()+khachHang.getName()+khachHang.getPassword();
	}
	*/
}
