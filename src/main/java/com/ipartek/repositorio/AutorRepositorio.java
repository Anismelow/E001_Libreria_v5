package com.ipartek.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipartek.modelo.Autor;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, Integer>{

}
