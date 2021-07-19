package com.beerproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.beerproject.domain.EstiloCerveja;

@Repository
public interface EstiloCervejaRepository extends JpaRepository<EstiloCerveja, Long> {

	@Query(value = " SELECT new com.beerproject.domain.EstiloCerveja(e.id, e.nomeEstilo, e.temperaturaMinima, e.temperaturaMaxima)  "
			+ " FROM EstiloCerveja e " + " WHERE e.nomeEstilo = :descricao ")
	EstiloCerveja buscaporDescricao(String descricao);

	@Query(value = " SELECT * FROM ESTILO_CERVEJA " 
			+ " WHERE (SELECT MAX(TEMPERATURA_MAXIMA) FROM ESTILO_CERVEJA WHERE TEMPERATURA_MAXIMA < :temperatura) = TEMPERATURA_MAXIMA "
			+ "	OR    (SELECT MIN(TEMPERATURA_MAXIMA) FROM ESTILO_CERVEJA WHERE TEMPERATURA_MAXIMA > :temperatura) = TEMPERATURA_MAXIMA " 
			+ " ORDER BY NOME_ESTILO "
			+ " LIMIT 1 ", nativeQuery = true)
	EstiloCerveja buscaTemperaturaMaxima(Integer temperatura);

	@Query(value = " SELECT * FROM ESTILO_CERVEJA " 
			+ " WHERE (SELECT MAX(TEMPERATURA_MINIMA) FROM ESTILO_CERVEJA WHERE TEMPERATURA_MINIMA < :temperatura) = TEMPERATURA_MINIMA "
			+ "	OR    (SELECT MIN(TEMPERATURA_MINIMA) FROM ESTILO_CERVEJA WHERE TEMPERATURA_MINIMA > :temperatura) = TEMPERATURA_MINIMA " 
			+ " ORDER BY NOME_ESTILO "
			+ " LIMIT 1 ", nativeQuery = true)
	EstiloCerveja buscaTemperaturaMinima(Integer temperatura);

	@Query(value = " SELECT new com.beerproject.domain.EstiloCerveja(e.id, e.nomeEstilo, e.temperaturaMinima, e.temperaturaMaxima) "
			+ " FROM EstiloCerveja e"
			+ " WHERE e.temperaturaMaxima = :temperatura OR e.temperaturaMinima = :temperatura")
	EstiloCerveja buscaTemperaturaExata(Integer temperatura);

}
