package com.ipartek.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ipartek.modelo.Libro;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Integer> {
//
//	@Query(value = """
//			select l from libros l
//			where autorFk=:idAutor
//			""")
//	public List<Libro> obtenerTodosLibrosPorAutor(@Param(value = "idAutor")  Integer idAutor);

	@Query(value = "select * from libros where autorFk=:idAutor", nativeQuery = true)
	public List<Libro> obtenerTodosLibrosPorAutor2(@Param(value = "idAutor") Integer idAutor);
	
	public List<Libro> findByAutorFKId(Integer id);
}
