package com.cwi.curso.jwra.desafio_java.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cwi.curso.jwra.desafio_java.entity.Vote;
import com.cwi.curso.jwra.desafio_java.repository.VoteRepository;
import com.cwi.curso.jwra.desafio_java.utils.ApiErroException;

@Service
public class VoteService {
	@Autowired
	private VoteRepository voteRepository;
	
	public void save(Vote entity) {
		if(entity==null)
			throw new ApiErroException("Informe dados do voto");
		voteRepository.save(entity);
	}

	public void update(Vote entity, Long id) {
		if(entity==null)
			throw new ApiErroException("Informe dados do voto");
		if(id ==null)
			throw new ApiErroException("Informe o id do voto");
		voteRepository.save(entity);
	}

	public List<Vote> listAll() {
		return voteRepository.findAll();
	}
	public void delete(Long id) {
		if(id == null)
			throw new ApiErroException("Informe o ID");
		Vote entityOld = voteRepository.findById(id).get();
		if(entityOld!=null)
			voteRepository.delete(entityOld);
		else
			throw new EntityNotFoundException("Dados não encontrados com id "+id+"!");
	}

}
