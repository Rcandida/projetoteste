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
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_empresa")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String idEmpresa;
	
	@Column(unique = true, length = 150)
	private String nomeEmpresa;
	
	@Column(unique = true, length = 14)
	private String cnpj;
	
	@Column(length = 15)
	private String segmento;
	
	

}