package br.com.adminfo.security.services;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.adminfo.security.models.Role;
import br.com.adminfo.security.models.User;
import br.com.adminfo.security.repository.RoleRepository;
import br.com.adminfo.security.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private BCryptPasswordEncoder bycrpt;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void save(User user) {
		user.setPassword(bycrpt.encode(user.getPassword()));
		user.setRoles(new HashSet<Role>(roleRepository.findAll()));
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}