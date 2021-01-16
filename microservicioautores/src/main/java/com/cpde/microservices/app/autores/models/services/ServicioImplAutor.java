package com.cpde.microservices.app.autores.models.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cpde.microservices.app.autores.models.entity.Autor;
import com.cpde.microservices.app.autores.models.repository.RepositorioAutor;

@Service
public class ServicioImplAutor implements ServicioAutor {

	@Autowired
	private RepositorioAutor repositorioautor;
	
	@Transactional (readOnly = true)
	public Iterable<Autor> findAll() {
		return repositorioautor.findAll();
	}

	@Override
	@Transactional (readOnly = true)
	public Optional<Autor> findById(Long id) {
		// TODO Auto-generated method stub
		return repositorioautor.findById(id);
	}

	@Override
	@Transactional
	public Autor save(Autor autor) {
		// TODO Auto-generated method stub
		return repositorioautor.save(autor);
	}

	@Override
	@Transactional
	public void deletedById(Long id) {
		// TODO Auto-generated method stub
		repositorioautor.deleteById(id);
	}

	@Override
	public Iterable<Autor> findBest() {
		// TODO Auto-generated method stub
		return repositorioautor.findBest();
	}


	
}
