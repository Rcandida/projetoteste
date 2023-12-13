package br.edu.unichristus.projetoteste.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.unichristus.projetoteste.data.model.Planilha;

public interface PlanilhaRepository extends JpaRepository<Planilha, String>{
	
	Optional<Planilha> findByIdPlanilha(String id);

	@Query("SELECT pl FROM Planilha pl WHERE pl.simulacao.idSimulacao = :simulacaoId")
    List<Planilha> findBySimulacao(@Param("simulacaoId") String simulacaoId);
}