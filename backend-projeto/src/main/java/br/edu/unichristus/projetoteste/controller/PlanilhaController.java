package br.edu.unichristus.projetoteste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unichristus.projetoteste.data.model.Planilha;
import br.edu.unichristus.projetoteste.repository.PlanilhaRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("planilha")
public class PlanilhaController {
	
	@Autowired
	private PlanilhaRepository repository;
	

	@Operation(summary = "Retorna os dados de todas as planilhas de simulação | role: [USUARIO]", tags = "Planilha")
    @GetMapping
    public List<Planilha> obterPorIdSimulacao(String simulacaoId) {
        return repository.findBySimulacao(simulacaoId);
    }
}


