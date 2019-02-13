package br.com.adminfo.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.adminfo.security.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String userName);
	
}