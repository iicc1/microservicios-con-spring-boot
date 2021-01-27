package com.cpcd.microservices.commons.cursos.models.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table (name = "estudiantes")
public class Estudiantes {
	
	public Estudiantes() {
		this.cursos = new ArrayList<>();
	}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Long DNI;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getDNI() {
		return DNI;
	}

	public void setDNI(Long dNI) {
		DNI = dNI;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos.clear();
		cursos.forEach(cu -> {
			this.addCurso(cu);
		});
	}
	
	public void addCurso(Curso curso) {
		this.cursos.add(curso);
		curso.addEstudiante(this);
	}
	
	public void elimnarCurso(Curso curso) {
		this.cursos.remove(curso);
		curso.eliminarEstudiante(this);
	}
	
	@ManyToMany(mappedBy = "estudiantes", fetch =FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Curso> cursos;
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof Curso)) {return false;}
		
		Curso cu = (Curso) obj;
		return this.id != null && this.id.equals(cu.getId());
	}

}
