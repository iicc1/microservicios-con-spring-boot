package com.cpde.microservices.app.autores.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.cpcd.microservices.commons.cursos.models.entity.Autor;


public interface RepositorioAutor extends CrudRepository<Autor, Long> {

		
}
	