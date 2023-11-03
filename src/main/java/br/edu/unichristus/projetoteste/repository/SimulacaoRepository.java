package br.edu.unichristus.projetoteste.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.projetoteste.data.model.Simulacao;

public interface SimulacaoRepository extends JpaRepository<Simulacao, String>{
	
	Optional<Simulacao> findByIdSimulacao(String id);
	
	Optional<Simulacao> findByNomeSimulacao(String nome);
		

}
