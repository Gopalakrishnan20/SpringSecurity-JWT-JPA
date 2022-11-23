package com.project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.models.AppUser;
import com.project.models.Roles;
@Service
public interface UserService {
	
	AppUser saveUser(AppUser user);
	Roles saveRole(Roles role);
	void addRoleToUser(String username,String roleName);
	AppUser getUser(String username);
	List<AppUser>getUser();
}
