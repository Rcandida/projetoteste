package br.edu.unichristus.projetoteste.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.projetoteste.data.model.Premissas;

public interface PremissasRepository extends JpaRepository<Premissas, String>{
	
	Optional<Premissas> findByIdPremissas(String id);
	
	

}
