package vn.holotruyentranh.app.service;

import java.util.ArrayList;
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
	
	public ImageChapter get(Long id) {
		Optional<ImageChapter> result = repo.findById(id);
		return result.get();
	}
	public void save(ImageChapter temp) {
		repo.save(temp);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<ImageChapter> getByIDchapter(Long IDchapter) {
		List<ImageChapter> list0 = (List<ImageChapter>)repo.findAll();
		List<ImageChapter> list1 = new ArrayList<ImageChapter>();
		for (ImageChapter imageChapter : list0) {
			if(imageChapter.getIDchapter() == IDchapter) {
				list1.add(imageChapter);
			}
		}
		return list1;
	}
}
