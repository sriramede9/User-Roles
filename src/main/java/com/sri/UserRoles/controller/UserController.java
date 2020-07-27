package com.sri.UserRoles.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sri.UserRoles.dao.UserRepository;
import com.sri.UserRoles.model.Role;
import com.sri.UserRoles.model.User;

@RestController
public class UserController {

	@Autowired
	private UserRepository userReposotory;

	@GetMapping("/test")
	public String test() {
		String s = "Hello!";
		return s;
	}

	@GetMapping("/createUser")
	public User CreateUser() {
		User u = new User();
		u.setEmail("test@gmail.com");
		u.setPassword("abc");
		u.setRoles(Collections.singleton(Role.USER));
		u.setUsername("testUser");

		User save = userReposotory.save(u);
		return save;
	}

	@GetMapping("/getallUsers")
	public List<User> getUsers() {
		return userReposotory.findAll().stream().filter(u -> u.isUser()).collect(Collectors.toList());
	}

	@GetMapping("/getSuperUsers")
	public List<User> getSuperUsers() {
		List<User> collect = userReposotory.findAll().stream().filter(u -> u.isSuperAdmin())
				.collect(Collectors.toList());
		return collect;
	}

	@GetMapping("/getadmins")
	public List<User> getAdmins() {
		List<User> collect = userReposotory.findAll().stream().filter(u -> u.isAdmin()).collect(Collectors.toList());
		return collect;
	}

		@PostMapping("/createSuperAdmin")
	public User addUser(@RequestBody User user) {

		System.out.println(user);
		User save = userReposotory.save(user);
		return save;
	}

	@PostMapping("/createAdmin")
	public User addAdmin(@RequestBody User user) {

		System.out.println(user);
		User save = userReposotory.save(user);
		return save;
	}

}
