package br.edu.unichristus.projetoteste.data.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimulacaoDTO {
	
	private String idSimulacao;
	
	
	//private String idEmpresa;//

	
	private String nomeSimulacao;

	
	private LocalDateTime dataCriacao = LocalDateTime.now();

}


