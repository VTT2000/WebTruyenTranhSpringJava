package vn.holotruyentranh.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.holotruyentranh.app.bean.Permission;
import vn.holotruyentranh.app.repository.PermissionRepository;

@Service
@Transactional
public class PermissionService {
	@Autowired
	PermissionRepository repo;
	public List<Permission> listAll(){
		return (List<Permission>) repo.findAll();
	}
	
	public Permission get(long id) {
		Optional<Permission> result = repo.findById(id);
		return result.get();
	}
	public void save(Permission temp) {
		repo.save(temp);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
