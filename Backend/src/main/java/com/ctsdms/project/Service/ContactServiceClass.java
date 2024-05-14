package com.ctsdms.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctsdms.project.Entity.Contact;
import com.ctsdms.project.Repository.ContactRepository;

@Service
public class ContactServiceClass implements ContactService {

	@Autowired
	ContactRepository repo;
	
	@Override
	public Contact addcontact(Contact contact) {
		// TODO Auto-generated method stub
		return repo.save(contact);
		
	}

	@Override
	public List<Contact> getallcontact() {
		// TODO Auto-generated method stub
		List<Contact> c=repo.findAll();
		return c;
	}

}
