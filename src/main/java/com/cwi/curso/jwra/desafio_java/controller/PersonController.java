package com.cwi.curso.jwra.desafio_java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cwi.curso.jwra.desafio_java.entity.Person;
import com.cwi.curso.jwra.desafio_java.response.Response;
import com.cwi.curso.jwra.desafio_java.service.PersonService;
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonService service;
	@GetMapping(value="/get")
	public ResponseEntity<Response<List<Person>>> get() {
		Response<List<Person>> response =  new Response<>();
		try {
			response.setStatus(200);
			response.setData(service.listAll());
		} catch (Exception e) {
			response.setStatus(500);
			response.setMessage(e.getMessage());			
		}
		return ResponseEntity.ok(response);
		
	}
	@PostMapping(value="/save")
	public ResponseEntity<Response<Person>> save(@RequestBody Person person) {
		Response<Person> response =  new Response<>();
		try {
			service.save(person);
			response.setStatus(200);
			
		} catch (Exception e) {
			response.setStatus(500);
			response.setMessage(e.getMessage());			
		}
		return ResponseEntity.ok(response);
	}
	@PutMapping(value="/update")
	public ResponseEntity<Response<Person>> update(@RequestBody Person person, @RequestParam Long id) {
		Response<Person> response =  new Response<>();
		try {
			service.update(person,id);
			response.setStatus(200);			
		} catch (Exception e) {
			response.setStatus(500);
			response.setMessage(e.getMessage());			
		}
		return ResponseEntity.ok(response);
	}
	@DeleteMapping(value="/delete")
	public ResponseEntity<Response<Person>> delete(@RequestParam Long id) {
		Response<Person> response =  new Response<>();
		try {
			service.delete(id);
			response.setStatus(200);
			
		} catch (Exception e) {
			response.setStatus(500);
			response.setMessage(e.getMessage());			
		}
		return ResponseEntity.ok(response);
	}
}
