package com.cwi.curso.jwra.desafio_java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cwi.curso.jwra.desafio_java.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
}
