package org.blog.api.services;

import org.blog.api.model.User;
import org.blog.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository uRepo;
	
	
	public User getUser(String username) {
	 return	uRepo.findByUsername(username);
	}
	
}
