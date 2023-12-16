package br.edu.unichristus.projetoteste.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.projetoteste.data.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, String>{
	
	Optional<Empresa> findByIdEmpresa(String id);
	
	Optional<Empresa> findByNomeEmpresa(String nome);

}
