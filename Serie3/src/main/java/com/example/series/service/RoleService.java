package com.example.series.service;

import java.util.List;

import com.example.series.entities.Role;


public interface RoleService {
	 List <Role> findAll();
	    
	 Role saveRole(Role r);
	 Role updateRole(Role r);
	 Role getRole (Long idRole);
}
