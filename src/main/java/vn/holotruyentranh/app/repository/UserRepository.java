package vn.holotruyentranh.app.repository;

import org.springframework.data.repository.CrudRepository;

import vn.holotruyentranh.app.bean.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
