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

}
