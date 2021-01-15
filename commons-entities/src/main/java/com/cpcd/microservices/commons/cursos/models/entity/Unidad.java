package com.cpcd.microservices.commons.cursos.models.entity;

import java.util.Date;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> d67b379fd135b0a244ae4457f620d95f84dcab04

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.ManyToMany;
=======
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
>>>>>>> d67b379fd135b0a244ae4457f620d95f84dcab04
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

<<<<<<< HEAD
=======
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;


>>>>>>> d67b379fd135b0a244ae4457f620d95f84dcab04
@Entity
@Table (name = "unidades")

public class Unidad {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descripcion;
	private String url;
	private Long valoracion;
	private String thumbnail;
	
<<<<<<< HEAD
	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "fechaCreacion")
	private Date fechaCreacion;
	
	//relacion contiene
	
	@ManyToMany(mappedBy = "unidades", fetch =FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Curso> cursos;
		
	
	
=======
>>>>>>> d67b379fd135b0a244ae4457f620d95f84dcab04
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	public Long getValoracion() {
		return valoracion;
	}

	public void setValoracion(Long valoracion) {
		this.valoracion = valoracion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
<<<<<<< HEAD
=======
	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "fechaCreacion")
	private Date fechaCreacion;
	
>>>>>>> d67b379fd135b0a244ae4457f620d95f84dcab04
	@PrePersist
	public void ponerFecha() {
		this.fechaCreacion = new Date();
	}
	
<<<<<<< HEAD
	
=======
	@JsonIgnoreProperties(value= {"unidades"})
	@ManyToOne
	@JoinColumn(name="autorid")
	private Autor autor;
	
	
	@ManyToMany(mappedBy = "unidades", fetch =FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Curso> cursos;
		
	
	
	public Autor getAutor() {
		return autor;
	}
	
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof Curso)) {return false;}
		
		Curso cu = (Curso) obj;
		return this.id!=null && this.id.equals(cu.getId());
		
	}
>>>>>>> d67b379fd135b0a244ae4457f620d95f84dcab04
}
