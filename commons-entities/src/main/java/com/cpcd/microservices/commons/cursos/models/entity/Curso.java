package com.cpcd.microservices.commons.cursos.models.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.UniqueConstraint;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table (name = "cursos")

public class Curso {
	
	public Curso() {
		this.estudiantes = new ArrayList<>();
	}

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private int valoracion;
	private String descripcion;
	private String url;
	private String thumbnail;
	
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
	
	
	@JsonIgnoreProperties(value = {"cursos"}, allowSetters = true)
	@ManyToMany
	@JoinTable(name="contiene",
			joinColumns=@JoinColumn(name="cursoid"),
			inverseJoinColumns=@JoinColumn(name="unidadid"),
			uniqueConstraints= {@UniqueConstraint(columnNames = {"cursoid", "unidadid"})}
			)
	private List<Unidad> unidades;
	
//	public List<Unidad> getUnidades(){
//		return unidades;
//	}
	
	public void setUnidades(List<Unidad> unidades) {
		this.unidades.clear();
		unidades.forEach(uni -> {
			this.addUnidad(uni);
		});	
	}
	
	private void addUnidad(Unidad unidad) {
		 this.unidades.add(unidad);
		 unidad.setCurso(this);
	}
	
	private void eliminarUnidad(Unidad unidad) {
		 this.unidades.remove(unidad);
		 unidad.setCurso(null);
	}
	
	@ManyToMany
	@JoinTable(name="matriculados",
			joinColumns=@JoinColumn(name="curso_id"),
			inverseJoinColumns=@JoinColumn(name="estudiante_id"),
			uniqueConstraints = {@UniqueConstraint(columnNames = {"curso_id","estudiante_id"})}
	)
	private List<Estudiante> estudiantes;
	
	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	
	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes.clear();
		estudiantes.forEach(es -> {
			this.addEstudiante(es);
		});
	}

	public void addEstudiante(Estudiante estudiante) {
		this.estudiantes.add(estudiante);
		estudiante.addCurso(this);
	}
	
	public void eliminarEstudiante(Estudiante estudiante) {
		this.estudiantes.remove(estudiante);
		estudiante.elimnarCurso(this);
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
