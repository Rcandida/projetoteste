package br.edu.unichristus.projetoteste.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_premissas")
public class Premissas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String idPremissas;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Simulacao simulacao;
	
	//Premissas
	
	private float premissa_faturamento;
	private float premissa_investimentoInicial;
	private float premissa_aliqComissaoVendas;
	private float premissa_aliqImpostoFaturamento;
    private float premissa_aliqImpostoLucro;
    private float premissa_equipe;
    private float premissa_despesasAdmin;
    private float premissa_precoMedioInsumos;
    private float premissa_precoMedioFreteEmb;
    private float premissa_despesasJurosAmort;
		
  //Taxas de Retorno
    private float retorno_payback;
	private float retorno_tma;
	private float retorno_tir;
	private float retorno_vpfcx;
	private float retorno_invest;
	private float retorno_vpl;
	
}