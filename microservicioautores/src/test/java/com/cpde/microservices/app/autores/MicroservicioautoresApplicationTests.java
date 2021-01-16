
package com.cpde.microservices.app.autores;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.cpde.microservices.app.autores.models.entity.Autor;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cpde.microservices.app.autores.models.entity.Autor;
import com.cpde.microservices.app.autores.models.repository.RepositorioAutor;

@DataJpaTest
@RunWith(SpringRunner.class)
@SpringBootTest

class MicroservicioautoresApplicationTests {

	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private RepositorioAutor repositorio;
	
	@Test
	public void testgetID() {
	
		long id = 1;
		long valoracion = 4;
		Autor aut = new Autor();
		aut.setId(id);
		aut.setValoracion(valoracion);
		repositorio.save(aut);
		entityManager.persist(aut);
		Optional<Autor> auttest = repositorio.findById(id);
		assertThat(aut.getId()).isEqualTo(auttest);	
	}
	@Test
	public void testgetAllSave() {
		long id = 1;
		long valoracion = 4;
		String name = "paco";
		String foto = "foto.png";
		Autor aut1 = new Autor();
		long id2 = 2;
		String name2 = "pepe";
		String foto2 = "fotoPe.png";
		Autor aut2 = new Autor();
		aut1.setId(id);
		aut1.setValoracion(valoracion);
		aut1.setNombre(name);
		aut1.setThumbnail(foto);
		aut2.setId(id2);
		aut2.setValoracion(valoracion);
		aut2.setNombre(name2);
		aut2.setThumbnail(foto2);
		repositorio.save(aut1);
		repositorio.save(aut2);
		Iterable<Autor> auttest = repositorio.findAll();
		assertThat(auttest).hasSize(2);
		
	}
	@Test 
	public void testdelete() {
		long id = 1;
		long valoracion = 4;
		String name = "paco";
		String foto = "foto.png";
		Autor aut1 = new Autor();
		aut1.setId(id);
		aut1.setValoracion(valoracion);
		aut1.setNombre(name);
		aut1.setThumbnail(foto);
		repositorio.save(aut1);
		repositorio.deleteById(id);
		assertThat(aut1.getId()).isNotEqualTo(id);
	}
	
	@Test 
	public void testdeleteID() {
		long id = 1;
		long valoracion = 4;
		String name = "paco";
		String foto = "foto.png";
		Autor aut1 = new Autor();
		aut1.setId(id);
		aut1.setValoracion(valoracion);
		aut1.setNombre(name);
		aut1.setThumbnail(foto);
		repositorio.deleteById(id);
		assertThat(aut1.getId()).isNotEqualTo(id);
	}
	
}
