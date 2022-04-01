package vn.holotruyentranh.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.holotruyentranh.app.bean.Chapter;
import vn.holotruyentranh.app.repository.ChapterRepository;

@Service
@Transactional
public class ChapterService {
	@Autowired
	ChapterRepository repo;
	public List<Chapter> listAll(){
		return (List<Chapter>) repo.findAll();
	}
	
	public Chapter get(long id) {
		Optional<Chapter> result = repo.findById(id);
		return result.get();
	}
	public void save(Chapter temp) {
		repo.save(temp);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
