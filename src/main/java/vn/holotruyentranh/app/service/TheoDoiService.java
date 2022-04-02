package vn.holotruyentranh.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.holotruyentranh.app.bean.TheoDoi;
import vn.holotruyentranh.app.repository.TheoDoiRepository;

@Service
@Transactional
public class TheoDoiService {
	@Autowired
	TheoDoiRepository repo;
	public List<TheoDoi> listAll(){
		return (List<TheoDoi>) repo.findAll();
	}
	
	public TheoDoi get(Long id) {
		Optional<TheoDoi> result = repo.findById(id);
		return result.get();
	}
	public void save(TheoDoi temp) {
		repo.save(temp);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
