package com.cpcd.microservices.app.estudiantes.controller;

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

import com.cpcd.microservices.app.estudiantes.models.entity.Estudiante;
import com.cpcd.microservices.app.estudiantes.services.ServicioEstudiante;

@RestController
public class ControladorEstudiante {

	@Autowired
	private ServicioEstudiante servicioestudiante;
	
	@GetMapping
	public ResponseEntity<?> devilverEstudiantes(){
		return ResponseEntity.ok().body(servicioestudiante.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> devolverEstuiante(@PathVariable Long id){
		Optional<Estudiante> es = servicioestudiante.findById(id);
		
		 if(es.isEmpty()){
			 return ResponseEntity.notFound().build();
			 
		 }else {
			 return ResponseEntity.ok(es.get());
		 }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrarEstudiante(@PathVariable Long id){
		servicioestudiante.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<?> addEstudiante(@RequestBody Estudiante estudiante){
		Estudiante es = servicioestudiante.save(estudiante);
		return ResponseEntity.status(HttpStatus.CREATED).body(es);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarEstudiante(@RequestBody Estudiante estudiante, @PathVariable Long id){
		Optional<Estudiante> es = servicioestudiante.findById(id);
		 if(es.isEmpty()){
			 return ResponseEntity.notFound().build();
		 }
		
		 Estudiante objestudiante = es.get();
		 objestudiante.setNombre(estudiante.getNombre());
		 objestudiante.setDNI(estudiante.getDNI());
		 // objestudiante.setId(estudiante.getId());
		 
		 Estudiante estudiante2 = servicioestudiante.save(objestudiante);
		 return ResponseEntity.status(HttpStatus.CREATED).body(estudiante2);
	}
	
}
