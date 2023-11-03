package br.edu.unichristus.projetoteste.data.dto;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimulacaoDTO {
	
	private String idSimulacao;
	
	
	//@ManyToOne
	//private Empresa empresa;

	
	private String nomeSimulacao;

	private LocalDate localDate = LocalDate.now();

}


