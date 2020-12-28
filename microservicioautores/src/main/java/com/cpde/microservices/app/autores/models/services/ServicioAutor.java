package com.cpde.microservices.app.autores.models.services;

import java.util.Optional;

import com.cpde.microservices.app.autores.models.entity.Autor;

public interface ServicioAutor {

		public Iterable <Autor> findAll();
		public Optional	<Autor> findById(Long id);
		
		//insertar y borrar
		public Autor save (Autor autor);
		
		public void deletedById(Long id);
}
