package com.project.repositories;

import java.util.Collection;

import javax.management.relation.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.models.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {
	
	Roles findByName(String name);

}
