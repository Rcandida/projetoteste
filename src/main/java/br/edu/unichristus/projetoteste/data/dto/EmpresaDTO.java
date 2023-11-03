package br.edu.unichristus.projetoteste.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDTO {
	
	private String idEmpresa;
	
	
	private String nomeEmpresa;
	
	
	private String cnpj;
	
	
	private String segmento;
	

}
