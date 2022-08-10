package com.cwi.curso.jwra.desafio_java.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dateCreated;
	@ManyToOne
	@JoinColumn(name="ID_SCHEDULE_VOTE", nullable=false)
	private ScheduleVote scheduleVote;
	@ManyToOne
	@JoinColumn(name = "ID_PERSON", nullable=false)
	private Person person;
}
