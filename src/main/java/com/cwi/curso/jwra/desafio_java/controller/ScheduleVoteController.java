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

import com.cwi.curso.jwra.desafio_java.entity.ScheduleVote;
import com.cwi.curso.jwra.desafio_java.entity.Vote;
import com.cwi.curso.jwra.desafio_java.response.Response;
import com.cwi.curso.jwra.desafio_java.service.ScheduleVoteService;

@RequestMapping("/schedule")
public class ScheduleVoteController {
	@Autowired
	private ScheduleVoteService service;
	@GetMapping(value="/get")
	public ResponseEntity<Response<List<ScheduleVote>>> get() {
		Response<List<ScheduleVote>> response =  new Response<>();
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
	public ResponseEntity<Response<Vote>> save(@RequestBody ScheduleVote entity) {
		Response<Vote> response =  new Response<>();
		try {
			service.save(entity);
			response.setStatus(200);
			
		} catch (Exception e) {
			response.setStatus(500);
			response.setMessage(e.getMessage());			
		}
		return ResponseEntity.ok(response);
	}
	@PutMapping(value="/update")
	public ResponseEntity<Response<ScheduleVote>> update(@RequestBody ScheduleVote entity, @RequestParam Long id) {
		Response<ScheduleVote> response =  new Response<>();
		try {
			service.update(entity,id);
			response.setStatus(200);			
		} catch (Exception e) {
			response.setStatus(500);
			response.setMessage(e.getMessage());			
		}
		return ResponseEntity.ok(response);
	}
	@DeleteMapping(value="/delete")
	public ResponseEntity<Response<ScheduleVote>> delete(@RequestParam Long id) {
		Response<ScheduleVote> response =  new Response<>();
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
