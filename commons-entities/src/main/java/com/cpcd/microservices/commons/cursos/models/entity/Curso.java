package com.cpcd.microservices.commons.cursos.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table (name = "cursos")

public class Curso {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	private Long id;
	private String titulo;
	private int valoracion;
	private String descripcion;
	private String url;
	private String thumbnail;
	
	@JsonIgnoreProperties(value= {"cursos"})
	@ManyToOne
	@JoinColumn(name="autorid")
	private Autor autor;
	
	public Autor getAutor() {
		return autor;
	}
	
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "fecha_creacion")
	private Date fechaCreacion;
	
	@PrePersist
	public void ponerFecha() {
		this.fechaCreacion = new Date();
	}
	
	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		if ( valoracion > 5) {
			this.valoracion = (int) 5;
	
		}else if (valoracion < 0) {
			this.valoracion = (int) 0;

		}else {
			this.valoracion = valoracion;
		}
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
}