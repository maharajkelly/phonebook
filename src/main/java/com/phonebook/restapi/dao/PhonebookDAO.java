package com.phonebook.restapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebook.restapi.model.Phonebook;
import com.phonebook.restapi.repository.PhonebookRepository;

@Service
public class PhonebookDAO {
	
	@Autowired
	PhonebookRepository phonebookRepository;
	
	//to  SAVE a phonebook record
	public Phonebook save(Phonebook phone) {
		return phonebookRepository.save(phone);
	}
	
	//SEARCH phonebook
	public List<Phonebook> findAll(){
		return phonebookRepository.findAll();
	}
	
	//UPDATE/GET phonebook record
	public Phonebook findOne(Long phoneId) {
		return phonebookRepository.findOne(phoneId);
	}
	
	//DELETE record
	public void delete(Phonebook phone) {
		phonebookRepository.delete(phone);
	}
	

}
