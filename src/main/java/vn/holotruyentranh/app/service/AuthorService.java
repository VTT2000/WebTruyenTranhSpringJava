package vn.holotruyentranh.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.holotruyentranh.app.bean.Author;
import vn.holotruyentranh.app.repository.AuthorRepository;

@Service
@Transactional
public class AuthorService {
	@Autowired
	AuthorRepository repo;
	
	public Page<Author> listAll(int pageNumber){
		Pageable pageable = PageRequest.of(pageNumber-1, 10); 
		return repo.findAll(pageable);
	}
	
	public List<Author> listAll(){
		return (List<Author>) repo.findAll();
	}
	
	public Author get(Long id) {
		Optional<Author> result = repo.findById(id);
		return result.get();
	}
	public void save(Author temp) {
		repo.save(temp);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
