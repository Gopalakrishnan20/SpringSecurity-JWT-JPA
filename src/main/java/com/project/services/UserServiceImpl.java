package com.project.services;


import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.models.AppUser;
import com.project.models.Roles;
import com.project.repositories.RoleRepository;
import com.project.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Override
	public AppUser saveUser(AppUser user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public Roles saveRole(Roles role) {
		// TODO Auto-generated method stu
		return roleRepo.save(role);
		
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		// TODO Auto-generated method stub
		AppUser user=userRepo.findByUsername(username);
	    Roles role=roleRepo.findByName((String) roleName);
		user.getRoles().add(role);
	}

	@Override
	public AppUser getUser(String username) {
		// TODO Auto-generated method stub
		return userRepo.findByUsername(username);
	}

	@Override
	public List<AppUser> getUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

}
