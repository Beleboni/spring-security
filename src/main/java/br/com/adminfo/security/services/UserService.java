package br.com.adminfo.security.services;

import br.com.adminfo.security.models.User;

public interface UserService {
	
	void save(User user);
	User findByUsername(String username);

}