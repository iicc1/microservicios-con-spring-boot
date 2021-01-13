package com.cpcd.microservices.app.cursos.controller;

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


import com.cpcd.microservices.app.cursos.services.ServicioCurso;
import com.cpcd.microservices.commons.cursos.models.entity.Curso;

@RestController
public class ControladorCurso {
	
	@Autowired
	private ServicioCurso serviciocurso;
	
	@GetMapping
	public ResponseEntity<?> devolverCursos(){
		return ResponseEntity.ok().body(serviciocurso.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> devolverCurso(@PathVariable Long id){
		Optional<Curso> cu = serviciocurso.findById(id);
		if(cu.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(cu.get());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrarCurso(@PathVariable Long id){
		serviciocurso.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<?> addCurso(@RequestBody Curso curso){
		Curso cu = serviciocurso.save(curso);
		return ResponseEntity.status(HttpStatus.CREATED).body(cu);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarCurso(@RequestBody Curso curso, @PathVariable Long id){
		Optional<Curso> cu = serviciocurso.findById(id);
		if(cu.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Curso ocurso = cu.get();
		ocurso.setTitulo(curso.getDescripcion());
		ocurso.setDescripcion(curso.getDescripcion());
		ocurso.setThumbnail(curso.getThumbnail());
		ocurso.setUrl(curso.getUrl());
		
		Curso ocurso2 = serviciocurso.save(ocurso);
		return ResponseEntity.status(HttpStatus.CREATED).body(ocurso2);
	}
	
}