package com.example.demo.service;

import java.util.List;

import com.example.demo.binding.ContactForm;

public interface ContactService 
{
	public String save(ContactForm form);
	public List<ContactForm> viewContact();
	public ContactForm editContact(Integer contactId);
	public List<ContactForm> deleteContact(Integer contactId);
	

}
