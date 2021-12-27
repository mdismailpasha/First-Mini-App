package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.binding.ContactForm;
import com.example.demo.entities.ContactEntity;
import com.example.demo.repo.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService
{
	@Autowired
	private ContactRepository repo;

	@Override
	public String save(ContactForm form) 
	{
		ContactEntity entity=new ContactEntity();
		BeanUtils.copyProperties(form,entity);
		entity.setActivesw("y");
		 entity = repo.save(entity);
		if(entity.getContactId() !=null)
		{
			return "success message";
		}
		
		return "Failure messgae";
	}

	@Override
	public List<ContactForm> viewContact()
	{
		List<ContactForm> list=new ArrayList<>();
		List<ContactEntity> findAll = repo.findAll();
		for(ContactEntity entites:findAll)
		{
			ContactForm form=new ContactForm();
			BeanUtils.copyProperties(entites, form);
			list.add(form);
		}
		
		return list;
		
	}

	@Override
	public ContactForm editContact(Integer contactId)
	{
		Optional<ContactEntity> findById = repo.findById(contactId);
		if(findById.isPresent())
		{
			ContactEntity entity=findById.get();
			ContactForm form=new ContactForm();
			BeanUtils.copyProperties(entity, form);		
			return form;
		}
		
		return null;
	}

	@Override
	public List<ContactForm> deleteContact(Integer contactId)
	{
		repo.deleteById(contactId);
		return viewContact();
	}

}
