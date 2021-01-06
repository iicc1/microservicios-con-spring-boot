package com.cpcd.microservices.app.unidades.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpcd.microservices.app.unidades.models.entity.Unidad;
import com.cpcd.microservices.app.unidades.services.ServicioUnidad;

@RestController
public class ControladorUnidad {
	
	@Autowired
	private ServicioUnidad serviciounidad;
	
	@GetMapping
	public ResponseEntity<?> devolverUnidades(){
		return ResponseEntity.ok().body(serviciounidad.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> devolverUnidad(@PathVariable Long id){
		Optional<Unidad> uni = serviciounidad.findById(id);
		if(uni.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(uni.get());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrarUnidad(@PathVariable Long id){
		serviciounidad.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<?> addUnidad(@RequestBody Unidad unidad){
		Unidad uni = serviciounidad.save(unidad);
		return ResponseEntity.status(HttpStatus.CREATED).body(uni);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarUnidad(@RequestBody Unidad unidad, @PathVariable Long id){
		Optional<Unidad> uni = serviciounidad.findById(id);
		if (uni.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Unidad optUnidad = uni.get();
		optUnidad.setTitulo(unidad.getDescripcion());
		optUnidad.setDescripcion(unidad.getDescripcion());
		optUnidad.setThumbnail(unidad.getThumbnail());
		optUnidad.setUrl(unidad.getUrl());
		
		Unidad unidad2 = serviciounidad.save(optUnidad);
		return ResponseEntity.status(HttpStatus.CREATED).body(unidad2);
	}
	
}
