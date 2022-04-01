package vn.holotruyentranh.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.holotruyentranh.app.bean.Comic;
import vn.holotruyentranh.app.repository.ComicRepository;

@Service
@Transactional
public class ComicService {
	@Autowired
	ComicRepository repo;
	public List<Comic> listAll(){
		return (List<Comic>) repo.findAll();
	}
	
	public Comic get(long id) {
		Optional<Comic> result = repo.findById(id);
		return result.get();
	}
	public void save(Comic temp) {
		repo.save(temp);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
