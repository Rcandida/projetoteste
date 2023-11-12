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
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/simulacao")
public class SimulacaoController {
	
	@Autowired
	private SimulacaoService service;
	
	@Operation(summary = "Cadastra o nome de um arquivo de simulacao | role: [USUARIO]", tags = "Simulacao")
	@PostMapping
	public SimulacaoDTO create(@RequestBody SimulacaoDTO simulacao) {
		return service.save(simulacao);
	}
	
	
	@Operation(summary = "Retorna o nome de um arquivo de simulacao | role: [USUARIO]", tags = "Simulacao")
	@GetMapping("/{id}")
	public SimulacaoDTO findByIdSimulacao(@PathVariable("id") String id) {
		return service.findByIdSimulacao(id);
	}
	
	@Operation(summary = "Deleta o nome de um arquivo de simulacao | role: [USUARIO]", tags = "Simulacao")
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
	
	@Operation(summary = "Retorna os nomes dos arquivos das simulações | role: [USUARIO]", tags = "Simulacao")
	@GetMapping
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok(service.findAll());
	}

}