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

import br.edu.unichristus.projetoteste.data.dto.PremissasDTO;
import br.edu.unichristus.projetoteste.service.PremissasService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/premissas")
public class PremissasController {
	
	@Autowired
	private PremissasService service;
	
	
	@Operation(summary = "Cadastra os dados de uma premissas de simulação | role: [USUARIO]", tags = "Premissas")
	@PostMapping
	public PremissasDTO create(@RequestBody PremissasDTO premissas) {
		return service.save(premissas);
	}
	
	@Operation(summary = "Retorna os dados de uma premissas de simulação | role: [USUARIO]", tags = "Premissas")	
	@GetMapping("/{id}")
	public PremissasDTO findByIdPremissas(@PathVariable("id") String id) {
		return service.findByIdPremissas(id);
	}
	
	@Operation(summary = "Deleta os dados de uma premissas de simulação | role: [USUARIO]", tags = "Premissas")
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
	
	@Operation(summary = "Retorna os dados de todas as premissass de simulação | role: [USUARIO]", tags = "Premissas")
	@GetMapping	
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok(service.findAll());
	}

	
	

}
