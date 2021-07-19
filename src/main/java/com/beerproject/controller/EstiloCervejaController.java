package com.beerproject.controller;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beerproject.domain.EstiloCerveja;
import com.beerproject.domain.dto.EstiloCervejaDTO;
import com.beerproject.service.EstiloCervejaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Cerveja")
@CrossOrigin(value = "*")
public class EstiloCervejaController {

	@Autowired
	private EstiloCervejaService service;

	@GetMapping("/cerveja")
	@ApiOperation(value = "Retorna uma lista de todos os estilos de cerveja")
	public List<EstiloCerveja> listarTodosEstilos() {
		return this.service.listarTodosEstilos();
	}

	@PostMapping("/cerveja")
	@ApiOperation(value = "Salva um estilo de cerveja")
	public ResponseEntity<?> salvar(@RequestBody EstiloCervejaDTO dto) throws ServiceException {

		return ResponseEntity.ok(this.service.salvar(dto));
	}

	@DeleteMapping("/cerveja")
	@ApiOperation(value = "Deleta um estilo de cerveja")
	public ResponseEntity<?> deletar(@RequestBody EstiloCervejaDTO dto) {
		return ResponseEntity.ok(this.service.deletar(dto));
	}

	@PutMapping("/cerveja")
	@ApiOperation(value = "Atualiza um estilo de cerveja")
	public ResponseEntity<?> atualizar(@RequestBody EstiloCervejaDTO dto) {
		return ResponseEntity.ok(this.service.salvar(dto));
	}
	
	@GetMapping("/cerveja{temperatura}")
	@ApiOperation(value = "Busca o seu estilo de cerveja baseado na temperatura que passar")
	public ResponseEntity<?> meuEstilo(@RequestParam Integer temperatura){
		return ResponseEntity.ok(this.service.meuEstilo(temperatura));
		
	}

}
