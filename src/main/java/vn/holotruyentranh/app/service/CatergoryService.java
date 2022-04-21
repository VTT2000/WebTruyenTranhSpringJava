package vn.holotruyentranh.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.holotruyentranh.app.bean.Catergory;
import vn.holotruyentranh.app.repository.CatergoryRepository;

@Service
@Transactional
public class CatergoryService {
	@Autowired
	CatergoryRepository repo;
	
	public Page<Catergory> listAll(int pageNumber){
		Pageable pageable = PageRequest.of(pageNumber-1, 10); 
		return repo.findAll(pageable);
	}
	
	public List<Catergory> listAll(){
		return (List<Catergory>) repo.findAll();
	}
	
	public Catergory get(Long id) {
		Optional<Catergory> result = repo.findById(id);
		return result.get();
	}
	public void save(Catergory temp) {
		repo.save(temp);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
