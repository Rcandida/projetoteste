package br.edu.unichristus.projetoteste.data.model;

import java.time.LocalDate;

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
@Table
public class Simulação {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String idSimulacao;
	
	
	//@ManyToOne
	//private Empresa empresa;

	@Column(unique = true, length = 100)
	private String nomeSimulacao;

	private LocalDate localDate = LocalDate.now();

}
