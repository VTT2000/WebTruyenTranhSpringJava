package vn.holotruyentranh.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.holotruyentranh.app.bean.User;
import vn.holotruyentranh.app.repository.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository repo;
	
	public Page<User> listAll(int pageNumber){
		Pageable pageable = PageRequest.of(pageNumber-1, 10); 
		return repo.findAll(pageable);
	}
	
	public List<User> listAll(){
		return (List<User>) repo.findAll();
	}
	
	public User get(Long id) {
		Optional<User> result = repo.findById(id);
		return result.get();
	}
	public void save(User temp) {
		repo.save(temp);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
