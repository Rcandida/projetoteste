package br.edu.unichristus.projetoteste.data.dto;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_empresa")
public class EmpresaDTO {
	
	private String idEmpresa;
	
	private String nomeEmpresa;
	
	private String cnpj;
	
	private String segmento;
	

}
