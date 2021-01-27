package com.cpcd.microservices.commons.cursos.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table (name = "autores")
public class Autor{
	//id, DNI, nombre, valoracion, thumbnail
	
	public Autor() {
		this.cursos = new ArrayList<>();
		this.unidades = new ArrayList<>();
	}
	
	
	//  los campos de la tabla autores 
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nombre",nullable=false)
	private String nombre;
	@Column(name = "valoracion")
	private Long valoracion;
	@Column(name = "foto")
	private String thumbnail;
	
	
	//metodos implementados para la relacion
	
	public List<Curso> getCursos(){
		return cursos;
	}
	
	public void setCursos(List<Curso> cursos) {
		this.getCursos().clear();
		cursos.forEach(cu -> {
			this.addCurso(cu);
		});	
	}
	
	private void addCurso(Curso curso) {
		 this.cursos.add(curso);
		 curso.setAutor(this);
	}
	
	private void eliminarCurso(Curso curso) {
		 this.cursos.remove(curso);
		 curso.setAutor(null);
	}
	
	public List<Unidad> getUnidades(){
		return unidades;
	}
	
	public void setUnidades(List<Unidad> unidades) {
		this.getUnidades().clear();
		unidades.forEach(uni -> {
			this.addUnidad(uni);
		});	
	}
	
	private void addUnidad(Unidad unidad) {
		 this.unidades.add(unidad);
		 unidad.setAutor(this);
	}
	
	private void eliminarUnidad(Unidad unidad) {
		 this.unidades.remove(unidad);
		 unidad.setAutor(null);
	}
	
	@JsonIgnoreProperties(value = {"autor"}, allowSetters = true)
	@OneToMany(mappedBy="autor", fetch =FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Curso> cursos;
	
	@JsonIgnoreProperties(value = {"autor"}, allowSetters = true)
	@OneToMany(mappedBy="autor", fetch =FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Unidad> unidades;
	//getters y setters 
	
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
	public Long getValoracion() {
		return valoracion;
	}
	public void setValoracion(Long valoracion) {
		this.valoracion = valoracion;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof Autor)) {return false;}
		
		Autor au = (Autor) obj;
		return this.id!=null && this.id.equals(au.getId());
		
	}
	

}
