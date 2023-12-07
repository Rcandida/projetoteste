package br.edu.unichristus.projetoteste.data.model;

import jakarta.persistence.CascadeType;
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
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Simulacao simulacao;
	
	
	//Premissas
	private double premissa_faturamento;
	private double premissa_investimentoInicial;
	private double premissa_aliqComissaoVendas;
	private double premissa_aliqImpostoFaturamento;
    private double premissa_aliqImpostoLucro;
    private double premissa_equipe;
    private double premissa_despesasAdmin;
    private double premissa_precoMedioInsumos;
    private double premissa_precoMedioFreteEmb;
    private double premissa_despesasJurosAmort;
    
    private String retorno_payback;
	private double retorno_tma;
	private double retorno_tir;
	private double retorno_vpfcx;
	private double retorno_invest;
	private double retorno_vpl;
	
}