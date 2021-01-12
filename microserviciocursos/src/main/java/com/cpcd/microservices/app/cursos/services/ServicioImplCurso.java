package com.cpcd.microservices.app.cursos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cpcd.microservices.app.cursos.models.entity.Curso;
import com.cpcd.microservices.app.cursos.models.repository.RepositorioCurso;

@Service
public class ServicioImplCurso implements ServicioCurso {

	@Autowired
	private RepositorioCurso repositoriocurso;
	
	@Override
	@Transactional (readOnly = true)
	public Iterable<Curso> findAll() {
		return repositoriocurso.findAll();
	}
	
	@Override
	@Transactional (readOnly = true)
	public Iterable<Curso> mejorValorados() {
		return repositoriocurso.mejorValorados();
	}
	
	@Override
	@Transactional (readOnly = true)
	public Iterable<Curso> ultimos() {
		return repositoriocurso.ultimos();
	}
	
	@Override
	@Transactional (readOnly = true)
	public Optional<Curso> findById(Long id) {
		return repositoriocurso.findById(id);
	}

	@Override
	@Transactional
	public Curso save(Curso curso) {
		return repositoriocurso.save(curso);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repositoriocurso.deleteById(id);
	}

}
