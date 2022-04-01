package vn.holotruyentranh.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.holotruyentranh.app.bean.TransPermission;
import vn.holotruyentranh.app.repository.TransPermissionRepository;

@Service
@Transactional
public class TransPermissionService {
	@Autowired
	TransPermissionRepository repo;
	public List<TransPermission> listAll(){
		return (List<TransPermission>) repo.findAll();
	}
	
	public TransPermission get(long id) {
		Optional<TransPermission> result = repo.findById(id);
		return result.get();
	}
	public void save(TransPermission temp) {
		repo.save(temp);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
