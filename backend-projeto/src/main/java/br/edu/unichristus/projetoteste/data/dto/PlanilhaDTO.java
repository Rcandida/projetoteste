package br.edu.unichristus.projetoteste.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanilhaDTO {
	
	
	
	private String idPlanilha;
	
	
	private String idSimulacao;
	
	
	private String mesAno;
	
	//Projecao de Resultados
	
	private double projecao_fatBruto;
	private double projecao_impostoSobreFat;	
	private double projecao_comissoesTaxasPagar;
	
	private double projecao_receitaLiqVendas;
	
	private double projecao_custosProducao;
	private double projecao_comprasMP;
	private double projecao_embalagens;
	private double projecao_entregas;
	private double projecao_pessoalProducao;
	
	private double projecao_lucroBruto;
	
	private double projecao_custosOperacionais;
	private double projecao_pessoalOperacional;
	private double projecao_administrativos;
	private double projecao_servicos;
	
	private double projecao_margemContribCustosOper;
	
	private double projecao_resultOperacional;
	private double projecao_jurosFinanciamento;
	
	private double projecao_resultTributavel;
	private double projecao_impostoSobreLucros;
	
	private double projecao_lucroLiquido;
	
	private double projecao_lucroLiquidoAcum;
	private double projecao_margemLucratividade;
	private double projecao_pontoEquilFinanceiro;
	
	
	//Fluxo de Caixa
	
	private double fluxo_entrada;
	private double fluxo_vendaProdutoServico;
	private double fluxo_emprestimo;
	private double fluxo_capitalProprio;
	private double fluxo_receitas;
	
	private double fluxo_saidas;
	private double fluxo_comissoes;
	private double fluxo_custoProducaoEntrega;
	private double fluxo_materiaPrimaInsumos;
	private double fluxo_embalagensFCCustoProd;
	private double fluxo_entregasFCCustoProd;
	private double fluxo_pessoalFCCustoProd;
	
	private double fluxo_custoFixo;
	private double fluxo_pessoalCustoFixo;
	private double fluxo_administrativosCustoFixo;
	private double fluxo_servicos;
	
	private double fluxo_investimentos;
	
	private double fluxo_despesasTributarias;
	private double fluxo_impostosApagar;
	private double fluxo_provisaoIR;
	
	private double fluxo_despesasFinanceiras;
	private double fluxo_jurosEmprestimo;
	private double fluxo_amortizacaoEmprestimo;
	
	private double periodo_fluxoMensal;
	private double periodo_acumulado;





}
