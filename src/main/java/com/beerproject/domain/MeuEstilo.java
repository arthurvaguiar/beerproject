package com.beerproject.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MeuEstilo implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("beerStyle")
	private String nomeEstilo;

	private List<String> playlist;

}
