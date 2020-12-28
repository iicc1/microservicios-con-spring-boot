package com.cpde.microservices.app.autores.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.cpde.microservices.app.autores.models.services.ServicioAutor;

@RestController 

public class ControladorCurso {

	
	@Autowired
	private ServicioAutor servicioautor;
	
	@GetMapping 
	public ResponseEntity<?> devolverAutores(){
		return ResponseEntity.ok().body(servicioautor.findAll());
	}
}
