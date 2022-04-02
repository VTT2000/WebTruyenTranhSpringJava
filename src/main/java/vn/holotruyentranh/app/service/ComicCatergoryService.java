package vn.holotruyentranh.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.holotruyentranh.app.bean.ComicCatergory;
import vn.holotruyentranh.app.repository.ComicCatergoryRepository;

@Service
@Transactional
public class ComicCatergoryService {
	@Autowired
	ComicCatergoryRepository repo;
	public List<ComicCatergory> listAll(){
		return (List<ComicCatergory>) repo.findAll();
	}
	
	public ComicCatergory get(Long id) {
		Optional<ComicCatergory> result = repo.findById(id);
		return result.get();
	}
	public void save(ComicCatergory temp) {
		repo.save(temp);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<ComicCatergory> getByIDcomic(Long id) {
		List<ComicCatergory> list0 = new ArrayList<ComicCatergory>();
		for (ComicCatergory comicCatergory : (List<ComicCatergory>)repo.findAll()) {
			if(comicCatergory.getIDcomic() == id) {
				list0.add(comicCatergory);
			}
		}
		return list0;
	}
	
	public List<ComicCatergory> getByIDcatergory(Long id) {
		List<ComicCatergory> list0 = new ArrayList<ComicCatergory>();
		for (ComicCatergory comicCatergory : (List<ComicCatergory>)repo.findAll()) {
			if(comicCatergory.getIDcatergory() == id) {
				list0.add(comicCatergory);
			}
		}
		return list0;
	}
}
