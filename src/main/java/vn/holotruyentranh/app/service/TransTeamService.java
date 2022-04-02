package vn.holotruyentranh.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.holotruyentranh.app.bean.TransTeam;
import vn.holotruyentranh.app.repository.TransTeamRepository;

@Service
@Transactional
public class TransTeamService {
	@Autowired
	TransTeamRepository repo;
	public List<TransTeam> listAll(){
		return (List<TransTeam>) repo.findAll();
	}
	
	public TransTeam get(Long id) {
		Optional<TransTeam> result = repo.findById(id);
		return result.get();
	}
	public void save(TransTeam temp) {
		repo.save(temp);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
