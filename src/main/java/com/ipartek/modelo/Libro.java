package com.ipartek.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="libros")
public class Libro {
	
	//atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="titulo", length = 90, nullable = false)
	private String titulo;
	
	@Column(name="precio", columnDefinition = "numeric(5,2) unsigned", nullable = false)
	private Double precio;

	@Column(name="esTapaDura",nullable = false)
	private Boolean esTapaDura;
	
	@ManyToOne
	@JoinColumn(name="autorFK", nullable = false)
	private Autor autorFK;

}
