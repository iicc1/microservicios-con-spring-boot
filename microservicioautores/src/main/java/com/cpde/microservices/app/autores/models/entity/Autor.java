package com.cpde.microservices.app.autores.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "autor")
public class Autor{
	//id, DNI, nombre, valoracion, thumbnail
	/*public Autor(Long id, String nombre, Long valoracion, String thumbnail ) {
		// TODO Auto-generated constructor stub
		this.id = id; 
		this.valoracion = valoracion;
		this.nombre = nombre; 
		this.thumbnail = thumbnail;
	}*/
	
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
		if ( valoracion > 5) {
			this.valoracion = (long) 5;
	
		}
		else if (valoracion < 0) 
		{
			this.valoracion = (long) 0;

		}
		else {
			this.valoracion = valoracion;
		}
	}
	
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}


}
