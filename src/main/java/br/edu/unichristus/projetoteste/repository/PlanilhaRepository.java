package br.edu.unichristus.projetoteste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.projetoteste.data.model.Planilha;

public interface PlanilhaRepository extends JpaRepository<Planilha, String>{

}
