package com.cpcd.microservices.app.unidades.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.cpcd.microservices.app.unidades.models.entity.Unidad;

public interface RepositorioUnidad extends CrudRepository<Unidad, Long> {

}
