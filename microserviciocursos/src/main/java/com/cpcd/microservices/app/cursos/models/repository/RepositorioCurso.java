package com.cpcd.microservices.app.cursos.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cpcd.microservices.app.cursos.models.entity.Curso;

public interface RepositorioCurso extends CrudRepository<Curso, Long> {
	
	@Query(nativeQuery=true, value= "select * from cursos a order by a.valoracion desc limit 5")
	public Iterable<Curso> mejorValorados();

}
