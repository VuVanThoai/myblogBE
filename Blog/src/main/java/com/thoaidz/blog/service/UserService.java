package com.thoaidz.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.thoaidz.blog.model.User;
import com.thoaidz.blog.repository.UserRepository;
import com.thoaidz.blog.security.CustomUserDetails;

@Service
public class UserService implements UserDetailsService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public CustomUserDetails getUserDetail(String username, String password) {
		User user = userRepository.getUser(username, password);
		System.out.println("----->");
		System.out.println(user);
		return new CustomUserDetails(user);
	}

	public UserDetails loadUserById(int id) {
		User user = userRepository.findById(id);
		if (user == null) {
			new UsernameNotFoundException("User not found with id : " + id);
			return null;
		}
		return new CustomUserDetails(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new CustomUserDetails(user);
	}

}
