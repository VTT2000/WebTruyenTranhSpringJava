package vn.holotruyentranh.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.holotruyentranh.app.bean.Chapter;
import vn.holotruyentranh.app.repository.ChapterRepository;

@Service
@Transactional
public class ChapterService {
	@Autowired
	ChapterRepository repo;
	
	public Page<Chapter> listAll(int pageNumber){
		Pageable pageable = PageRequest.of(pageNumber-1, 10); 
		return repo.findAll(pageable);
	}
	
	public List<Chapter> listAll(){
		return (List<Chapter>) repo.findAll();
	}
	
	public Chapter get(Long id) {
		Optional<Chapter> result = repo.findById(id);
		return result.get();
	}
	public void save(Chapter temp) {
		repo.save(temp);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<Chapter> getByIDcomic(Long IDcomic) {
		List<Chapter> list0 = (List<Chapter>)repo.findAll();
		List<Chapter> list1 = new ArrayList<Chapter>();
		for (Chapter chapter : list0) {
			if(chapter.getIDcomic() == IDcomic) {
				list1.add(chapter);
			}
		}
		return list1;
	}
	
	public Chapter getChapterPrevious(Long IDcomic, Long IDchapter) {
		List<Chapter> list0 = (List<Chapter>)repo.findAll();
		List<Chapter> list1 = new ArrayList<Chapter>();
		for (int i = 0; i < list0.size(); i++) {
			if(list0.get(i).getIDcomic() == IDcomic) {
				list1.add(list0.get(i));
			}
		}
		Chapter x = null;
		for (int i = 0; i < list1.size(); i++) {
			if(list1.get(i).getIDchapter() == IDchapter) {
				if((i-1) > -1) {
					x = list1.get(i-1);
				}
			}
		}
		return x;
	}
	
	public Chapter getChapterNexts(Long IDcomic, Long IDchapter) {
		List<Chapter> list0 = (List<Chapter>)repo.findAll();
		List<Chapter> list1 = new ArrayList<Chapter>();
		for (int i = 0; i < list0.size(); i++) {
			if(list0.get(i).getIDcomic() == IDcomic) {
				list1.add(list0.get(i));
			}
		}
		
		Chapter x = null;
		for (int i = 0; i < list1.size(); i++) {
			if(list1.get(i).getIDchapter() == IDchapter) {
				if((i+1) < list1.size()) {
					x = list1.get(i+1);
				}
			}
		}
		return x;
	}
}
