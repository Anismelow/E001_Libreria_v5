package com.ipartek.modelo;

import java.time.LocalDate;

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
@Table(name = "peliculas")
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "titulo", length = 90, nullable = false)
	private String titulo;

	@Column(name = "duracion", columnDefinition = "integer unsigned default 0", nullable = false)
	private Integer duracion;

	@Column(name = "estreno", nullable = false)
	private LocalDate estreno;

	@ManyToOne
	@JoinColumn(name ="categoriaFK", nullable = false )
	private Categoria categoriaFK;

}
