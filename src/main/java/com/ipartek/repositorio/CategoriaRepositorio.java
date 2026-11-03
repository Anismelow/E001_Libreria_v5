package com.ipartek.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ipartek.modelo.Categoria;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer>{

    @Query(value="Insert into categorias values(:id, :cat)", nativeQuery=true)
    public void insertarConId(@Param(value = "id")Integer id,@Param(value = "cat")String cat);

    
    @Query(value = "ALTER TABLE categorias AUTO_INCREMENT = 1 ", nativeQuery = true)
    public void resetearAutoInc();

}
