package com.cpde.microservices.app.autores.controller;

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

import com.cpcd.microservices.commons.cursos.models.entity.Autor;
import com.cpde.microservices.app.autores.models.services.ServicioAutor;

@RestController 

public class ControladorCurso {

	
	@Autowired
	private ServicioAutor servicioautor;
	
	@GetMapping 
	public ResponseEntity<?> devolverAutores(){
		return ResponseEntity.ok().body(servicioautor.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> devolverAutor(@PathVariable Long id){
		Optional<Autor> aut = servicioautor.findById(id);
		
		if (aut.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {	
			return ResponseEntity.ok(aut.get());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarAutor(@PathVariable Long id){
		servicioautor.deletedById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<?> añadirAutor(@RequestBody Autor autor){
		Autor aut = servicioautor.save(autor);
		return ResponseEntity.status(HttpStatus.CREATED).body(aut);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarAutor(@RequestBody Autor autor, @PathVariable Long id){
		Optional<Autor> aut = servicioautor.findById(id);
		if (aut.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Autor objautor =  aut.get();
		objautor.setNombre(autor.getNombre());
		objautor.setThumbnail(autor.getThumbnail());
		objautor.setValoracion(autor.getValoracion());
		
		
		Autor autorsaved = servicioautor.save(objautor);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(autorsaved);
		
		
	}
}
