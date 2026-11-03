package com.ipartek.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ipartek.modelo.Categoria;


@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer>{

    @Modifying 
    @Transactional 
    @Query(value="Insert into categorias values(:id, :cat)", nativeQuery=true)
    public void insertarConId(@Param(value = "id")Integer id,@Param(value = "cat")String cat);

    @Modifying 
    @Transactional 
    @Query(value = "ALTER TABLE categorias AUTO_INCREMENT = 1 ", nativeQuery = true)
    public void resetearAutoInc();

}
