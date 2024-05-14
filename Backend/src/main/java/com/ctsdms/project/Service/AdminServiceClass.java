package com.ctsdms.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctsdms.project.Entity.Admin;
import com.ctsdms.project.Repository.AdminRepository;

@Service
public class AdminServiceClass implements AdminService {
	
	@Autowired
	AdminRepository repo;

	@Override
	public List<Admin> getAllAdmins() {
		List<Admin> admins=repo.findAll();
		return admins;
	}
	

	@Override
	public Admin FindById(Long id) {
		List<Admin> admins=repo.findAll();
		for(Admin a:admins) {
			if(a.getAdmin_id()==id) {
				return a;
			}
		}
		return null;
	}

	@Override
	public Admin addAdmin(Admin admin) {
		Admin added_admin=repo.save(admin);
		return added_admin;
	}
	
	
	


}
