package com.beerproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "estilo_cerveja")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstiloCerveja {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nomeEstilo;
	
	private Integer temperaturaMinima;
	
	private Integer temperaturaMaxima;

}
