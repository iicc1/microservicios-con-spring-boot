package com.cpcd.microservices.app.unidades.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cpcd.microservices.app.unidades.models.entity.Unidad;
import com.cpcd.microservices.app.unidades.models.repository.RepositorioUnidad;

@Service
public class ServicioImplUnidad implements ServicioUnidad {

	@Autowired
	private RepositorioUnidad repositorioUnidad;
	
	@Override
	@Transactional (readOnly = true)
	public Iterable<Unidad> findAll() {
		return repositorioUnidad.findAll();
	}

	@Override
	@Transactional (readOnly = true)
	public Optional<Unidad> findById(Long id) {
		return repositorioUnidad.findById(id);
	}

	@Override
	@Transactional
	public Unidad save(Unidad unidad) {
		return repositorioUnidad.save(unidad);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repositorioUnidad.deleteById(id);
	}
}
