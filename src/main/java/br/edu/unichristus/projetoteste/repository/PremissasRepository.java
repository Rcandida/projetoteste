package br.edu.unichristus.projetoteste.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.unichristus.projetoteste.data.model.Premissas;

public interface PremissasRepository extends JpaRepository<Premissas, String>{
	
	Optional<Premissas> findByIdPremissas(String id);
	
	@Query("SELECT p FROM Premissas p WHERE p.simulacao.id = :simulacaoId")
    List<Premissas> findBySimulacaoId(@Param("simulacaoId") String simulacaoId);
}