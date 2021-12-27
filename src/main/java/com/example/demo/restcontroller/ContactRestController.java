package com.example.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.binding.ContactForm;
import com.example.demo.service.ContactService;

@RestController
public class ContactRestController {
	@Autowired
	private ContactService contactser;

	@PostMapping("/saveContact")
	public String saveContact(@RequestBody ContactForm form) {
		return contactser.save(form);

	}

	@GetMapping("/contacts")
	public List<ContactForm> viewAllContacts() {
		System.out.println("******method() executing*****");
		return contactser.viewContact();

	}

	@GetMapping("/edit/{contactId}")
	public ContactForm editcontact(@PathVariable Integer contactId) {
		return contactser.editContact(contactId);

	}

	@DeleteMapping("/delete/{contactId}")
	public List<ContactForm> deleteContact(@PathVariable Integer contactId) {
		 return contactser.deleteContact(contactId);
		
	}
}
