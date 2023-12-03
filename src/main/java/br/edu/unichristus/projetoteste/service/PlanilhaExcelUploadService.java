package br.edu.unichristus.projetoteste.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import br.edu.unichristus.projetoteste.data.model.Planilha;

public class PlanilhaExcelUploadService {
	
	public static boolean isValidExcelFile(MultipartFile file) {
		return Objects.equals(file.getContentType(),"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	}
	
	public static List<Planilha> getPlanilhaDataFromExcel(InputStream inputStream){
        List<Planilha> planilha = new ArrayList<>();

      
       try {
                   
    	   XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
           Sheet sheet = workbook.getSheet("Projeções - Cenário A");

           
          
           for(int c = 4; c < 17; c++) {
        	   
        	   String mesAno = sheet.getRow(18).getCell(c).getStringCellValue();
        	   
        	   double projecao_fatBruto = sheet.getRow(19).getCell(c).getNumericCellValue();
        	   double projecao_impostoSobreFat = sheet.getRow(20).getCell(c).getNumericCellValue();
        	   double projecao_comissoesTaxasPagar = sheet.getRow(21).getCell(c).getNumericCellValue();
           
        	   double projecao_receitaLiqVendas = sheet.getRow(22).getCell(c).getNumericCellValue();
           
        	   double projecao_custosProducao = sheet.getRow(23).getCell(c).getNumericCellValue();
        	   double projecao_comprasMP = sheet.getRow(24).getCell(c).getNumericCellValue();
        	   double projecao_embalagens = sheet.getRow(25).getCell(c).getNumericCellValue();
        	   double projecao_entregas = sheet.getRow(26).getCell(c).getNumericCellValue();
        	   double projecao_pessoalProducao = sheet.getRow(27).getCell(c).getNumericCellValue();
           
        	   double projecao_lucroBruto = sheet.getRow(28).getCell(c).getNumericCellValue();
       	   
	           double projecao_custosOperacionais = sheet.getRow(29).getCell(c).getNumericCellValue();
	       	   double projecao_pessoalOperacional = sheet.getRow(30).getCell(c).getNumericCellValue();
	       	   double projecao_administrativos = sheet.getRow(31).getCell(c).getNumericCellValue();
	       	   double projecao_servicos = sheet.getRow(32).getCell(c).getNumericCellValue();
	       	   
	       	   double projecao_margemContribCustosOper = sheet.getRow(33).getCell(c).getNumericCellValue();
	       	   
	       	   double projecao_resultOperacional = sheet.getRow(34).getCell(c).getNumericCellValue();
	       	   double projecao_jurosFinanciamento = sheet.getRow(35).getCell(c).getNumericCellValue();
	    	
	       	   double projecao_resultTributavel = sheet.getRow(36).getCell(c).getNumericCellValue();
	       	   double projecao_impostoSobreLucros = sheet.getRow(37).getCell(c).getNumericCellValue();
	    	
	       	   double projecao_lucroLiquido = sheet.getRow(38).getCell(c).getNumericCellValue();
	    	
	       	   double projecao_lucroLiquidoAcum = sheet.getRow(39).getCell(c).getNumericCellValue();
	       	   double projecao_margemLucratividade = sheet.getRow(40).getCell(c).getNumericCellValue();
	       	   double projecao_pontoEquilFinanceiro = sheet.getRow(41).getCell(c).getNumericCellValue();
	       	   
	       	   
	       	   double fluxo_entrada = sheet.getRow(45).getCell(c).getNumericCellValue();
		       double fluxo_emprestimo = sheet.getRow(46).getCell(c).getNumericCellValue();
		       double fluxo_vendaProdutoServico = sheet.getRow(47).getCell(c).getNumericCellValue();
		       double fluxo_capitalProprio = sheet.getRow(48).getCell(c).getNumericCellValue();
		       double fluxo_receitas = sheet.getRow(49).getCell(c).getNumericCellValue();
		    	
		       double fluxo_saidas = sheet.getRow(50).getCell(c).getNumericCellValue();
		       double fluxo_comissoes = sheet.getRow(51).getCell(c).getNumericCellValue();
		       double fluxo_custoProducaoEntrega = sheet.getRow(52).getCell(c).getNumericCellValue();
		       double fluxo_materiaPrimaInsumos = sheet.getRow(53).getCell(c).getNumericCellValue();
		       double fluxo_embalagensFCCustoProd = sheet.getRow(54).getCell(c).getNumericCellValue();
		       double fluxo_entregasFCCustoProd = sheet.getRow(55).getCell(c).getNumericCellValue();
		       double fluxo_pessoalFCCustoProd = sheet.getRow(56).getCell(c).getNumericCellValue();
		    	
		       double fluxo_custoFixo = sheet.getRow(57).getCell(c).getNumericCellValue();
		       double fluxo_pessoalCustoFixo = sheet.getRow(58).getCell(c).getNumericCellValue();
		       double fluxo_administrativosCustoFixo = sheet.getRow(59).getCell(c).getNumericCellValue();
		       double fluxo_servicos = sheet.getRow(60).getCell(c).getNumericCellValue();
		    	
		       double fluxo_investimentos = sheet.getRow(61).getCell(c).getNumericCellValue();
		    	
		       double fluxo_despesasTributarias = sheet.getRow(62).getCell(c).getNumericCellValue();
		       double fluxo_impostosApagar = sheet.getRow(63).getCell(c).getNumericCellValue();
		       double fluxo_provisaoIR = sheet.getRow(64).getCell(c).getNumericCellValue();
		    	
		       double fluxo_despesasFinanceiras = sheet.getRow(65).getCell(c).getNumericCellValue();
		       double fluxo_jurosEmprestimo = sheet.getRow(66).getCell(c).getNumericCellValue();
		       double fluxo_amortizacaoEmprestimo = sheet.getRow(67).getCell(c).getNumericCellValue();
		    	
		       double periodo_fluxoMensal = sheet.getRow(68).getCell(c).getNumericCellValue();
		       double periodo_acumulado = sheet.getRow(69).getCell(c).getNumericCellValue();
		       
		       Planilha dados = new Planilha();
		       
		       dados.setMesAno(mesAno);
		       
		       dados.setProjecao_fatBruto(projecao_fatBruto);
		       dados.setProjecao_impostoSobreFat(projecao_impostoSobreFat);
	    	   dados.setProjecao_comissoesTaxasPagar(projecao_comissoesTaxasPagar);
	       
		       dados.setProjecao_receitaLiqVendas(projecao_receitaLiqVendas);
		       
		       dados.setProjecao_custosProducao(projecao_custosProducao);
		       dados.setProjecao_comprasMP(projecao_comprasMP);
		       dados.setProjecao_embalagens(projecao_embalagens);
		       dados.setProjecao_entregas(projecao_entregas);
		       dados.setProjecao_pessoalProducao(projecao_pessoalProducao);
		       
		       dados.setProjecao_lucroBruto(projecao_lucroBruto);
		       
		       dados.setProjecao_custosOperacionais(projecao_custosOperacionais);
		       dados.setProjecao_pessoalOperacional(projecao_pessoalOperacional);
		       dados.setProjecao_administrativos(projecao_administrativos);
		       dados.setProjecao_servicos(projecao_servicos);
		       
		       dados.setProjecao_margemContribCustosOper(projecao_margemContribCustosOper);
		       
		       dados.setProjecao_resultOperacional(projecao_resultOperacional);
		       dados.setProjecao_jurosFinanciamento(projecao_jurosFinanciamento);
		       
		       dados.setProjecao_resultTributavel(projecao_resultTributavel);
		       dados.setProjecao_impostoSobreLucros(projecao_impostoSobreLucros);
		       
		       dados.setProjecao_lucroLiquido(projecao_lucroLiquido);
		       
		       dados.setProjecao_lucroLiquidoAcum(projecao_lucroLiquidoAcum);
		       dados.setProjecao_margemLucratividade(projecao_margemLucratividade);
		       dados.setProjecao_pontoEquilFinanceiro(projecao_pontoEquilFinanceiro);
		       
		       
		       dados.setFluxo_entrada(fluxo_entrada);
		       dados.setFluxo_vendaProdutoServico(fluxo_vendaProdutoServico);
		       dados.setFluxo_emprestimo(fluxo_emprestimo);
		       dados.setFluxo_capitalProprio(fluxo_capitalProprio);
		       dados.setFluxo_receitas(fluxo_receitas);
		       
		       dados.setFluxo_saidas(fluxo_saidas);
		       
		       dados.setFluxo_comissoes(fluxo_comissoes);
		       
		       dados.setFluxo_custoProducaoEntrega(fluxo_custoProducaoEntrega);
		       dados.setFluxo_materiaPrimaInsumos(fluxo_materiaPrimaInsumos);
		       dados.setFluxo_embalagensFCCustoProd(fluxo_embalagensFCCustoProd);
		       dados.setFluxo_entregasFCCustoProd(fluxo_entregasFCCustoProd);
		       dados.setFluxo_pessoalFCCustoProd(fluxo_pessoalFCCustoProd);
		       
		       dados.setFluxo_custoFixo(fluxo_custoFixo);
		       dados.setFluxo_pessoalCustoFixo(fluxo_pessoalCustoFixo);
		       dados.setFluxo_administrativosCustoFixo(fluxo_administrativosCustoFixo);
		       dados.setFluxo_servicos(fluxo_servicos);
		       
		       dados.setFluxo_investimentos(fluxo_investimentos);
		       
		       dados.setFluxo_despesasTributarias(fluxo_despesasTributarias);
		       dados.setFluxo_impostosApagar(fluxo_impostosApagar);
		       dados.setFluxo_provisaoIR(fluxo_provisaoIR);
		       
		       dados.setFluxo_despesasFinanceiras(fluxo_despesasFinanceiras);       
		       dados.setFluxo_jurosEmprestimo(fluxo_jurosEmprestimo);
		       dados.setFluxo_amortizacaoEmprestimo(fluxo_amortizacaoEmprestimo);
		       
		       dados.setPeriodo_fluxoMensal(periodo_fluxoMensal);
		       dados.setPeriodo_acumulado(periodo_acumulado);
		       
		       planilha.add(dados);
		       
		       System.out.println(dados);
	       	   
           }
           
       } catch (IOException e) {
           e.getStackTrace();
       }
       System.out.println(planilha);
       return planilha;
   }

  }





