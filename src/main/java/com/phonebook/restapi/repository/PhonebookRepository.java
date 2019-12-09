package com.phonebook.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phonebook.restapi.model.Phonebook;

public interface PhonebookRepository extends JpaRepository<Phonebook, Long>{

}
