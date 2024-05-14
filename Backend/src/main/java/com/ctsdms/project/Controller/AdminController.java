package com.ctsdms.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctsdms.project.Entity.Admin;
import com.ctsdms.project.Entity.Customer;
import com.ctsdms.project.Service.AdminService;
import com.ctsdms.project.Service.CustomerService;



@RestController
@RequestMapping("dining/admin")
public class AdminController {

	@Autowired
	AdminService service;
	
  @PostMapping("/add")
  public Admin addadmin(@RequestBody Admin admin) {
	return service.addAdmin(admin);
  }
	
	@GetMapping("/getall")
	public List<Admin> getAllAdmins(){
		List<Admin> admins=service.getAllAdmins();
		return admins;
	}
	
	@GetMapping("/getbyid/{admin_id}")
	public Admin getAdminById(@PathVariable Long admin_id) {
		Admin admin=service.FindById(admin_id);
		return admin;
	}
	
	
}
