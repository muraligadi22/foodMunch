package com.ctsdms.project.Service;

import java.util.List;

import com.ctsdms.project.Entity.Admin;

public interface AdminService {
	
	 Admin addAdmin(Admin admin);
	 List<Admin> getAllAdmins();
	 Admin FindById(Long id);
}
