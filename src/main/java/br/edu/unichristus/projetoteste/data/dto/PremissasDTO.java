package br.edu.unichristus.projetoteste.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PremissasDTO {
	
	
	private String idPremissas;
	
	private String idSimulacao;
	
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