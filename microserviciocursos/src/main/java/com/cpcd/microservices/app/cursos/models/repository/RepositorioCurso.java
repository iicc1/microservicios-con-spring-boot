package com.cpcd.microservices.app.cursos.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.cpcd.microservices.commons.cursos.models.entity.Curso;


public interface RepositorioCurso extends CrudRepository<Curso, Long> {

}
