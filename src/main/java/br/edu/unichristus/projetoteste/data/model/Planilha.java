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
@Table(name = "tb_planilha")
public class Planilha {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String idPlanilha;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Premissas premissas;
	
	private String mesAno;
	
	//Projecao de Resultados
	
	private float projecao_fatBruto;
	private float projecao_impostoSobreFat;	
	private float projecao_comissoesTaxasPagar;
	
	private float projecao_receitaLiqVendas;
	
	private float projecao_custosProducao;
	private float projecao_comprasMP;
	private float projecao_embalagens;
	private float projecao_entregas;
	private float projecao_pessoalProducao;
	
	private float projecao_lucroBruto;
	
	private float projecao_custosOperacionais;
	private float projecao_pessoalOperacional;
	private float projecao_administrativos;
	private float projecao_servicos;
	
	private float projecao_margemContribCustosOper;
	
	private float projecao_resultOperacional;
	private float projecao_jurosFinanciamento;
	
	private float projecao_resultTributavel;
	private float projecao_impostoSobreLucros;
	
	private float projecao_lucroLiquido;
	
	private float projecao_lucroLiquidoAcum;
	private float projecao_margemLucratividade;
	private float projecao_pontoEquilFinanceiro;
	
	
	//Fluxo de Caixa
	
	private float fluxo_entrada;
	private float fluxo_vendaProdutoServico;
	private float fluxo_capitalProprio;
	private float fluxo_receitas;
	
	private float fluxo_saidas;
	private float fluxo_comissoes;
	private float fluxo_custoProducaoEntrega;
	private float fluxo_materiaPrimaInsumos;
	private float fluxo_embalagensFCCustoProd;
	private float fluxo_entregasFCCustoProd;
	private float fluxo_pessoalFCCustoProd;
	
	private float fluxo_pessoalCustoFixo;
	private float fluxo_administrativosCustoFixo;
	private float fluxo_servicos;
	
	private float fluxo_investimentos;
	
	private float fluxo_despesasTributarias;
	private float fluxo_impostosApagar;
	private float fluxo_provisaoIR;
	
	private float fluxo_despesasFinanceiras;
	private float fluxo_jurosEmprestimo;
	private float fluxo_amortizacaoEmprestimo;
	
	private float periodo_fluxoMensal;
	private float periodo_acumulado;


	}
