package com.example.series.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.series.entities.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
