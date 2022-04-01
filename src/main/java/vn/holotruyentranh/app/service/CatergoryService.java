package vn.holotruyentranh.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.holotruyentranh.app.bean.Catergory;
import vn.holotruyentranh.app.repository.CatergoryRepository;

@Service
@Transactional
public class CatergoryService {
	@Autowired
	CatergoryRepository repo;
	public List<Catergory> listAll(){
		return (List<Catergory>) repo.findAll();
	}
	
	public Catergory get(long id) {
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
