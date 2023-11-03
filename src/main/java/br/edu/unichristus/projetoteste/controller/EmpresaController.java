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

@RestController
@RequestMapping("empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaService service;
	
	@PostMapping
	public EmpresaDTO create(@RequestBody EmpresaDTO empresa) {
		return service.save(empresa);
	}
	
	@PutMapping
	public EmpresaDTO update(@RequestBody EmpresaDTO empresa) {
		return service.save(empresa);
	}
	
	@GetMapping("/{id}")
	public EmpresaDTO findByIdEmpresa(@PathVariable("id") String id) {
		return service.findByIdEmpresa(id);
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