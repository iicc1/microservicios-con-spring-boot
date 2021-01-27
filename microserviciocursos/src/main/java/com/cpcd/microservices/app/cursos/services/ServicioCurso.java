package com.cpcd.microservices.app.cursos.services;

import java.util.Optional;

import com.cpcd.microservices.commons.cursos.models.entity.Curso;


public interface ServicioCurso {
	
	public Iterable<Curso> findAll();
	
	public Optional<Curso> findById(Long id);
	
	public Curso save(Curso curso);
	
	public void deleteById(Long id);
	
	public Iterable<Curso> mejorValorados();
	
	public Iterable<Curso> ultimos();
	
}