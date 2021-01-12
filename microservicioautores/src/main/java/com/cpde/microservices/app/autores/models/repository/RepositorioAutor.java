package com.cpde.microservices.app.autores.models.repository;

<<<<<<< Updated upstream
//import org.springframework.data.jpa.repository.Query;
=======
import org.springframework.data.jpa.repository.Query;
>>>>>>> Stashed changes
import org.springframework.data.repository.CrudRepository;
import com.cpde.microservices.app.autores.models.entity.Autor;

public interface RepositorioAutor extends CrudRepository<Autor, Long> {

<<<<<<< Updated upstream
	//@Query("select autor.valoracion from autor order by valoracion DESC limit 5")
	//Iterable<Autor> findBest();
		
=======
	@Query(nativeQuery= true, value = "select * from autor order by valoracion DESC limit 5")
	public Iterable<Autor> findBest();
>>>>>>> Stashed changes
}
	