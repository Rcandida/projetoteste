package br.edu.unichristus.projetoteste.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.projetoteste.data.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
//	User findByEmailAndPassword(String email, String password); // ele verifica os dois juntos
	
	Optional<User> findByEmail(String email);
	

	Optional<User> findByLogin(String login);
	
	Optional<User> findByLoginAndPassword(String login, String password);
	
	

}
