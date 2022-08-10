package com.cwi.curso.jwra.desafio_java.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cwi.curso.jwra.desafio_java.entity.Person;
import com.cwi.curso.jwra.desafio_java.repository.PersonRepository;
import com.cwi.curso.jwra.desafio_java.utils.ApiErroException;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;
	
	public void save(Person entity) {
		if(entity==null)
			throw new ApiErroException("Informe dados da pessoa");
		personRepository.save(entity);
	}

	public void update(Person entity, Long id) {
		if(entity==null)
			throw new ApiErroException("Informe dados da pessoa");
		if(id == null)
			throw new ApiErroException("Informe o ID");
		Person entityOld = personRepository.findById(id).get();
		if(entityOld!=null)
			personRepository.save(entity);
		else
			throw new EntityNotFoundException("Dados não encontrados com id "+id+"!");
	}

	public List<Person> listAll() {
		return personRepository.findAll();
	}
	public void delete(Long id) {
		if(id == null)
			throw new ApiErroException("Informe o ID");
		Person entityOld = personRepository.findById(id).get();
		if(entityOld!=null)
			personRepository.delete(entityOld);
		else
			throw new EntityNotFoundException("Dados não encontrados com id "+id+"!");
	}
} 
