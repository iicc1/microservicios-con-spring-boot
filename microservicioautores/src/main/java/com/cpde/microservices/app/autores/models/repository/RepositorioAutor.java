package com.cpde.microservices.app.autores.models.repository;

import org.springframework.data.repository.CrudRepository;
import com.cpde.microservices.app.autores.models.entity.Autor;

public interface RepositorioAutor extends CrudRepository<Autor, Long> {

		
}
	