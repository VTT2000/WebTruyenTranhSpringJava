package vn.holotruyentranh.app.service;

import java.util.ArrayList;
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
	
	public List<ComicTrans> getByIDcomic(Long id) {
		List<ComicTrans> list0 = new ArrayList<ComicTrans>();
		for (ComicTrans comicTrans : (List<ComicTrans>)repo.findAll()) {
			if(comicTrans.getIDcomic() == id) {
				list0.add(comicTrans);
			}
		}
		return list0;
	}
	
	public List<ComicTrans> getByIDteam(Long id) {
		List<ComicTrans> list0 = new ArrayList<ComicTrans>();
		for (ComicTrans comicTrans : (List<ComicTrans>)repo.findAll()) {
			if(comicTrans.getIDteam() == id) {
				list0.add(comicTrans);
			}
		}
		return list0;
	}
}
