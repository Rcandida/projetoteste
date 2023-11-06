package br.edu.unichristus.projetoteste.data.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Simulacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String idSimulacao;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Empresa empresa;

	@Column(unique = true, length = 100)
	private String nomeSimulacao;

	private LocalDateTime dataCriacao = LocalDateTime.now();

}
