package com.efarmkart.app.service.adminService;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efarmkart.app.model.adminModel.AdminUser;
import com.efarmkart.app.repository.adminRepo.AdminUserRepo;

@Service
public class AdminUserService {

	@Autowired
	private AdminUserRepo adminuserrepo;
	
	public List<AdminUser> getAllAdmin(){
		return adminuserrepo.findAll();
	}
	
	public AdminUser createAdminUser(AdminUser adminusr) {
		return adminuserrepo.save(adminusr);
	}
	
	public Optional<AdminUser> getAdminById(Long id) {
		return adminuserrepo.findById(id);
	}
	
	public Optional<AdminUser> deleteAdminById(Long id) {
	    Optional<AdminUser> adminUserOptional = adminuserrepo.findById(id);
	    adminUserOptional.ifPresent(adminuserrepo::delete);
	    return adminUserOptional;
	}

}
