package com.cpcd.microservices.app.estudiantes.services;

import java.util.Optional;

import com.cpcd.microservices.commons.cursos.models.entity.Estudiante;
//import com.cpcd.microservices.app.estudiantes.models.entity.Estudiante;

public interface ServicioEstudiante {

	public Iterable<Estudiante> findAll();
	
	public Optional<Estudiante> findById(Long id);
	
	public Estudiante save(Estudiante estudiante);
	
	public void deleteById(Long id);
}
