package vn.holotruyentranh.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.holotruyentranh.app.bean.Comic;
import vn.holotruyentranh.app.repository.ComicRepository;

@Service
@Transactional
public class ComicService {
	@Autowired
	ComicRepository repo;
	
	public Page<Comic> listAll(int pageNumber){
		Pageable pageable = PageRequest.of(pageNumber-1, 10); 
		return repo.findAll(pageable);
	}
	
	public List<Comic> listAll(){
		return (List<Comic>) repo.findAll();
	}
	
	public Comic get(Long id) {
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
