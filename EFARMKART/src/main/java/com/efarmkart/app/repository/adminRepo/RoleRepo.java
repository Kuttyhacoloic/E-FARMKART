package com.efarmkart.app.repository.adminRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.efarmkart.app.model.adminModel.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long>{

}
