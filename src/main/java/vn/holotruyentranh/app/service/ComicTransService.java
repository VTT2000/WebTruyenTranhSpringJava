package vn.holotruyentranh.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.holotruyentranh.app.bean.ComicTrans;
import vn.holotruyentranh.app.repository.ComicTransRepository;

@Service
@Transactional
public class ComicTransService {
	@Autowired
	ComicTransRepository repo;
	public List<ComicTrans> listAll(){
		return (List<ComicTrans>) repo.findAll();
	}
	
	public ComicTrans get(long id) {
		Optional<ComicTrans> result = repo.findById(id);
		return result.get();
	}
	public void save(ComicTrans temp) {
		repo.save(temp);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
