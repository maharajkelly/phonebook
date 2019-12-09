package com.phonebook.restapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phonebook.restapi.dao.PhonebookDAO;
import com.phonebook.restapi.model.Phonebook;

@RestController
@RequestMapping("/contacts")
public class PhonebookCtrl {

	@Autowired
	PhonebookDAO phonebookDAO;
	
	//SAVE contact in phonebook
	@PostMapping("/contactNumber")
	public Phonebook createContact(@Valid @RequestBody Phonebook phone) {
		return phonebookDAO.save(phone);
	}
	
	//GET all contacts
	@GetMapping("/contactNumber")
	public List<Phonebook> getAllContacts(){
		return phonebookDAO.findAll();
	}
	
	//SEARCH phonebook
	@GetMapping("/notes/(id)")
	public ResponseEntity<Phonebook> getContactById(@PathVariable(value="id") Long phoneid){
		Phonebook phone = phonebookDAO.findOne(phoneid);
		
		if(phone == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(phone);
	}
	
	//UPDATE record
	@PutMapping("/contactNumber/{id}")
	public ResponseEntity<Phonebook> updatePhonebook(@PathVariable(value="id") Long phoneid, @Valid @RequestBody Phonebook contactDetails){
		Phonebook phone=phonebookDAO.findOne(phoneid);
		if(phone == null) {
			return ResponseEntity.notFound().build();
		}
		phone.setName(contactDetails.getName());
		phone.setemail(contactDetails.getemail());
		phone.setphoneNumber(contactDetails.getphoneNumber());
		
		Phonebook updatePhonebook = phonebookDAO.save(phone);
		return ResponseEntity.ok().body(updatePhonebook);
	}
	
	//DELETE Contact
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<Phonebook> deletePhonebook(@PathVariable(value="id") Long phoneid){
		Phonebook phone=phonebookDAO.findOne(phoneid);
		if(phone == null) {
			return ResponseEntity.notFound().build();
		}
		
		phonebookDAO.delete(phone);
		return ResponseEntity.ok().build();
	}
}
