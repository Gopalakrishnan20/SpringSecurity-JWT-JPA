package com.project.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.models.AppUser;
import com.project.models.Roles;
import com.project.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	ResponseEntity<List<AppUser>> getUsers(){
		return ResponseEntity.ok().body(userService.getUser());
	}
	
	@PostMapping("/user/save")
	ResponseEntity<AppUser> saveUser(@RequestBody AppUser user){
		URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
		return ResponseEntity.created(uri).body(userService.saveUser(user));
		
	}
	
	@PostMapping("/role/save")
	ResponseEntity<Roles> saveRole(@RequestBody Roles role){
		URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
		return ResponseEntity.created(uri).body(userService.saveRole(role));
		
	}
	
	@PostMapping("/role/addtouser")
	ResponseEntity<?> assignRoleToUser(@RequestBody RoleToUserForm form){
		userService.addRoleToUser(form.getUsername(), form.getPassword());
		return ResponseEntity.ok().build();
	}
}

class RoleToUserForm{
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
