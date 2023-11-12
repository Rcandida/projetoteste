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

import br.edu.unichristus.projetoteste.data.dto.PlanilhaDTO;
import br.edu.unichristus.projetoteste.service.PlanilhaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/planilha")
public class PlanilhaController {
	
	@Autowired
	private PlanilhaService service;
	
	
	@Operation(summary = "Cadastra os dados de uma planilha de simulação | role: [USUARIO]", tags = "Planilha")
	@PostMapping
	public PlanilhaDTO create(@RequestBody PlanilhaDTO planilha) {
		return service.save(planilha);
	}
	
	@Operation(summary = "Retorna os dados de uma planilha de simulação | role: [USUARIO]", tags = "Planilha")	
	@GetMapping("/{id}")
	public PlanilhaDTO findByIdPlanilha(@PathVariable("id") String id) {
		return service.findByIdPlanilha(id);
	}
	
	@Operation(summary = "Deleta os dados de uma planilha de simulação | role: [USUARIO]", tags = "Planilha")
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
	
	@Operation(summary = "Retorna os dados de todas as planilhas de simulação | role: [USUARIO]", tags = "Planilha")
	@GetMapping	
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok(service.findAll());
	}

	
	

}
