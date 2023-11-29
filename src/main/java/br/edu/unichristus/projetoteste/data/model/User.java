package br.edu.unichristus.projetoteste.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor  
@NoArgsConstructor 
@Entity 
@Table(name = "tb_user")  
public class User {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.UUID) 
	private String id;
	
	@Column(length = 100) 
	private String name;
		
	private String email;
	
	@Column(unique = true)
	private String login;
	
	private String password;

}