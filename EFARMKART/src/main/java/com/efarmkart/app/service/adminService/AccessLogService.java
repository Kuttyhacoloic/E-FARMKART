package com.efarmkart.app.service.adminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efarmkart.app.model.adminModel.AccessLog;
import com.efarmkart.app.repository.adminRepo.AccessLogRepo;

@Service
public class AccessLogService {
	
	@Autowired
	private AccessLogRepo accesslogrepo;
	
	public List<AccessLog> getAllLogs() {
		return accesslogrepo.findAll();
	}
	
	public AccessLog createLog(AccessLog accesslog) {
		return accesslogrepo.save(accesslog);
	}
	
	public AccessLog getAdminById(Long id) {
		return accesslogrepo.getById(id);
	}
	
}
