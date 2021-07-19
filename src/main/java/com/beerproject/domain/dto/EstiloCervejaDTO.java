package com.beerproject.domain.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EstiloCervejaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nomeEstilo;
	private Integer temperaturaMinima;
	private Integer temperaturaMaxima;
	
	public EstiloCervejaDTO() {	}

	public EstiloCervejaDTO(Long id, String nomeEstilo, Integer temperaturaMinima, Integer temperaturaMaxima) {
		this.id = id;
		this.nomeEstilo = nomeEstilo;
		this.temperaturaMinima = temperaturaMinima;
		this.temperaturaMaxima = temperaturaMaxima;
	}

	@Override
	public String toString() {
		return "EstiloCervejaDTO [id=" + id + ", nomeEstilo=" + nomeEstilo + ", temperaturaMinima=" + temperaturaMinima
				+ ", temperaturaMaxima=" + temperaturaMaxima + "]";
	}
	

}
