package com.cpcd.microservices.app.unidades.services;

import java.util.Optional;

import com.cpcd.microservices.app.unidades.models.entity.Unidad;

public interface ServicioUnidad {
	
	public Iterable<Unidad> findAll();
	
	public Optional<Unidad> findById(Long id);
	
	public Unidad save(Unidad unidad);
	
	public void deleteById(Long id);
}
