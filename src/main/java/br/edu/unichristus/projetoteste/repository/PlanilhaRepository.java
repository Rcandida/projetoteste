package br.edu.unichristus.projetoteste.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.projetoteste.data.model.Planilha;

public interface PlanilhaRepository extends JpaRepository<Planilha, String> {
	
	Optional<Planilha> findByIdPlanilha(String id);
	
}
