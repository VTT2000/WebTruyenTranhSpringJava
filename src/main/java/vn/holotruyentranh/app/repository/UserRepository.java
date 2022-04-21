package vn.holotruyentranh.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.holotruyentranh.app.bean.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
