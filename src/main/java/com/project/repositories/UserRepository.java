package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.models.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long>{
	
	AppUser findByUsername(String username);
	
}
