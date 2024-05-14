package com.ctsdms.project.Service;

import java.util.List;

import com.ctsdms.project.Entity.Contact;

public interface ContactService {

	
	Contact addcontact(Contact contact);
	List<Contact> getallcontact();
}
