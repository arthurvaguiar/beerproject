package com.beerproject.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beerproject.domain.EstiloCerveja;
import com.beerproject.domain.MeuEstilo;
import com.beerproject.domain.dto.EstiloCervejaDTO;
import com.beerproject.repository.EstiloCervejaRepository;
import com.beerproject.util.FunctionUtil;

@Service
public class EstiloCervejaService {

	@Autowired
	private EstiloCervejaRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public List<EstiloCerveja> listarTodosEstilos() {
		return this.repository.findAll();
	}

	public EstiloCervejaDTO salvar(EstiloCervejaDTO dto) {
		EstiloCerveja estiloCerveja = null;

		estiloCerveja = this.busca(dto.getId(), dto.getNomeEstilo());

		if (FunctionUtil.isEmpty(estiloCerveja)) {
			estiloCerveja = modelMapper.map(dto, EstiloCerveja.class);
		} else {
			estiloCerveja.setNomeEstilo(dto.getNomeEstilo());
			estiloCerveja.setTemperaturaMaxima(dto.getTemperaturaMaxima());
			estiloCerveja.setTemperaturaMinima(dto.getTemperaturaMinima());
		}
		estiloCerveja = this.repository.save(estiloCerveja);
		return dto;
	}

	public String deletar(EstiloCervejaDTO dto) {
		try {
			if (!FunctionUtil.isEmpty(dto.getId())) {
				this.repository.deleteById(dto.getId());
			} else {
				try {

					EstiloCerveja estiloCerveja = new EstiloCerveja();
					estiloCerveja = this.repository.buscaporDescricao(dto.getNomeEstilo());
					if (!FunctionUtil.isEmpty(estiloCerveja)) {
						this.repository.deleteById(estiloCerveja.getId());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return "Exclusão realizada com sucesso!";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private EstiloCerveja busca(Long id, String nomeEstilo) {
		if (FunctionUtil.isEmpty(id)) {
			return this.repository.buscaporDescricao(nomeEstilo);
		} else {
			return this.repository.getById(id);
		}
	}

	public Object meuEstilo(Integer temperatura) {
		EstiloCerveja estiloCerveja = null ;
		if (!FunctionUtil.isEmpty(temperatura)) {
			estiloCerveja = this.repository.buscaTemperaturaExata(temperatura);
		}
		if (FunctionUtil.isEmpty(estiloCerveja) && temperatura >= 0) {
			estiloCerveja = this.repository.buscaTemperaturaMaxima(temperatura);

		} else if (FunctionUtil.isEmpty(estiloCerveja) && temperatura <=  0) {
			estiloCerveja = this.repository.buscaTemperaturaMinima(temperatura);
		}
		return montarMeuEstilo(estiloCerveja);
	}

	private MeuEstilo montarMeuEstilo(EstiloCerveja estiloCerveja) {
		MeuEstilo meuEstilo =  new MeuEstilo();
		meuEstilo.setNomeEstilo(estiloCerveja.getNomeEstilo());
		return meuEstilo;
	}

}
