package br.edu.unichristus.projetoteste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unichristus.projetoteste.data.model.Premissas;
import br.edu.unichristus.projetoteste.repository.PremissasRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("premissas")
public class PremissasController {

	
	@Autowired
	private PremissasRepository repository;
	


	@Operation(summary = "Retorna os dados de todas as premissass de simulação | role: [USUARIO]", tags = "Premissas")
    @GetMapping
    public List<Premissas> obterPorIdSimulacao(String simulacaoId) {
        return repository.findBySimulacaoId(simulacaoId);
    }
}


