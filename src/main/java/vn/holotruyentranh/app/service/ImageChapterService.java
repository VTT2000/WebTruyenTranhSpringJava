package vn.holotruyentranh.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.holotruyentranh.app.bean.ImageChapter;
import vn.holotruyentranh.app.repository.ImageChapterRepository;

@Service
@Transactional
public class ImageChapterService{
	@Autowired
	ImageChapterRepository repo;
	public List<ImageChapter> listAll(){
		return (List<ImageChapter>) repo.findAll();
	}
	
	public ImageChapter get(long id) {
		Optional<ImageChapter> result = repo.findById(id);
		return result.get();
	}
	public void save(ImageChapter temp) {
		repo.save(temp);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
