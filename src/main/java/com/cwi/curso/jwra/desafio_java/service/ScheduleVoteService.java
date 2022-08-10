package com.cwi.curso.jwra.desafio_java.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cwi.curso.jwra.desafio_java.entity.ScheduleVote;
import com.cwi.curso.jwra.desafio_java.repository.ScheduleVoteRepository;
import com.cwi.curso.jwra.desafio_java.utils.ApiErroException;

@Service
public class ScheduleVoteService {
	@Autowired
	private ScheduleVoteRepository scheduleVoteRepository;
	
	public void save(ScheduleVote entity) {
		if(entity==null)
			throw new ApiErroException("Informe dados da palta");
		scheduleVoteRepository.save(entity);
	}

	public void update(ScheduleVote entity, Long id) {
		if(entity==null)
			throw new ApiErroException("Informe dados da palta");
		if(id ==null)
			throw new ApiErroException("Informe o id do palta");
		scheduleVoteRepository.save(entity);
	}

	public List<ScheduleVote> listAll() {
		return scheduleVoteRepository.findAll();
	}
	public void delete(Long id) {
		if(id == null)
			throw new ApiErroException("Informe o ID");
		ScheduleVote entityOld = scheduleVoteRepository.findById(id).get();
		if(entityOld!=null)
			scheduleVoteRepository.delete(entityOld);
		else
			throw new EntityNotFoundException("Dados não encontrados com id "+id+"!");
	}
}
