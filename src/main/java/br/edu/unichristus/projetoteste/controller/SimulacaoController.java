package br.edu.unichristus.projetoteste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unichristus.projetoteste.data.dto.SimulacaoDTO;
import br.edu.unichristus.projetoteste.service.SimulacaoService;

@RestController
@RequestMapping("simulacao")
public class SimulacaoController {
	
	@Autowired
	private SimulacaoService service;
	
	@PostMapping
	public SimulacaoDTO create(@RequestBody SimulacaoDTO simulacao) {
		return service.save(simulacao);
	}
	
		
	@GetMapping("/{id}")
	public SimulacaoDTO findByIdSimulacao(@PathVariable("id") String id) {
		return service.findByIdSimulacao(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok(service.findAll());
	}

}