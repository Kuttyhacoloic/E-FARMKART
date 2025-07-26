package com.efarmkart.app.service.adminService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efarmkart.app.model.adminModel.AdminUser;
import com.efarmkart.app.model.adminModel.Role;
import com.efarmkart.app.repository.adminRepo.RoleRepo;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepo rolereop;
	
	public List<Role> getAllRole(){
		return rolereop.findAll();
	}
	
	public Role createRole(Role role) {
		return rolereop.save(role);
	}
	
	public Optional<Role> getRoleById(Long id) {
		return rolereop.findById(id);
	}

	public Optional<Role> deleteAdminById(Long id) {
	    Optional<Role> roleOptional = rolereop.findById(id);
	    roleOptional.ifPresent(rolereop::delete);
	    return roleOptional;
	}
}
