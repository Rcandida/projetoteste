package br.edu.unichristus.projetoteste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.projetoteste.data.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
//	User findByEmailAndPassword(String email, String password); // ele verifica os dois juntos
	
User findByEmail(String email);
	
	User findByLogin(String login);
	
	User findByLoginAndPassword(String login, String password);

}