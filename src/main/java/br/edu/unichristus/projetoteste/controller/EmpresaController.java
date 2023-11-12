package br.edu.unichristus.projetoteste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unichristus.projetoteste.data.dto.EmpresaDTO;
import br.edu.unichristus.projetoteste.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaService service;
	
	@Operation(summary = "Cadastra os dados de uma empresa | role: [USUARIO]", tags = "Empresa")
	@PostMapping
	public EmpresaDTO create(@RequestBody EmpresaDTO empresa) {
		return service.save(empresa);
	}
	
	@Operation(summary = "Altera os dados de uma empresa | role: [USUARIO]", tags = "Empresa")
	@PutMapping
	public EmpresaDTO update(@RequestBody EmpresaDTO empresa) {
		return service.save(empresa);
	}
	
	@Operation(summary = "Retorna os dados de uma empresa | role: [USUARIO]", tags = "Empresa")
	@GetMapping("/{id}")
	public EmpresaDTO findByIdEmpresa(@PathVariable("id") String id) {
		return service.findByIdEmpresa(id);
	}
	
	@Operation(summary = "Deleta os dados de uma empresa | role: [USUARIO]", tags = "Empresa")
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
	
	@Operation(summary = "Retorna os dados todas as empresas cadastradas | role: [USUARIO]", tags = "Empresa")
	@GetMapping	
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok(service.findAll());
	}

}