package br.edu.unichristus.projetoteste.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.edu.unichristus.projetoteste.data.model.Premissas;
import br.edu.unichristus.projetoteste.data.model.Simulacao;


@Service
public class PremissasExcelUploadService {
	
	
	public static boolean isValidExcelFile(MultipartFile file) {
		return Objects.equals(file.getContentType(),"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	}
	
	public static List<Premissas> getPremissasDataFromExcel(InputStream inputStream, Simulacao simulacao){
        List<Premissas> premissas = new ArrayList<>();

      
       try {
                   
    	   XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
           Sheet sheet = workbook.getSheet("Projeções - Cenário A");

           
           double premissa_faturamento = sheet.getRow(3).getCell(2).getNumericCellValue();
           double premissa_investimentoInicial = sheet.getRow(4).getCell(2).getNumericCellValue();
           double premissa_aliqComissaoVendas = sheet.getRow(5).getCell(2).getNumericCellValue();
       	   double premissa_aliqImpostoFaturamento = sheet.getRow(6).getCell(2).getNumericCellValue();
           double premissa_aliqImpostoLucro = sheet.getRow(7).getCell(2).getNumericCellValue();
           double premissa_equipe = sheet.getRow(8).getCell(2).getNumericCellValue();
           double premissa_despesasAdmin = sheet.getRow(9).getCell(2).getNumericCellValue();
           double premissa_precoMedioInsumos = sheet.getRow(10).getCell(2).getNumericCellValue();
           double premissa_precoMedioFreteEmb = sheet.getRow(11).getCell(2).getNumericCellValue();
           double premissa_despesasJurosAmort = sheet.getRow(12).getCell(2).getNumericCellValue();
           String retorno_payback = sheet.getRow(2).getCell(9).getStringCellValue();
       	   double retorno_tma = sheet.getRow(3).getCell(9).getNumericCellValue();
       	   double retorno_tir = sheet.getRow(4).getCell(9).getNumericCellValue();
       	   double retorno_vpfcx = sheet.getRow(5).getCell(9).getNumericCellValue();
       	   double retorno_invest = sheet.getRow(6).getCell(9).getNumericCellValue();
       	   double retorno_vpl = sheet.getRow(7).getCell(9).getNumericCellValue();
           
           Premissas premissa = new Premissas();
           
           premissa.setSimulacao(simulacao);
           
           premissa.setPremissa_faturamento(premissa_faturamento);
           premissa.setPremissa_investimentoInicial(premissa_investimentoInicial);
           premissa.setPremissa_aliqComissaoVendas(premissa_aliqComissaoVendas);
           premissa.setPremissa_aliqImpostoFaturamento(premissa_aliqImpostoFaturamento);
           premissa.setPremissa_aliqImpostoLucro(premissa_aliqImpostoLucro);
           premissa.setPremissa_equipe(premissa_equipe);
           premissa.setPremissa_despesasAdmin(premissa_despesasAdmin);
           premissa.setPremissa_precoMedioInsumos(premissa_precoMedioInsumos);
           premissa.setPremissa_precoMedioFreteEmb(premissa_precoMedioFreteEmb);
           premissa.setPremissa_despesasJurosAmort(premissa_despesasJurosAmort);
           premissa.setRetorno_payback(retorno_payback);
           premissa.setRetorno_tma(retorno_tma);
           premissa.setRetorno_tir(retorno_tir);
           premissa.setRetorno_vpfcx(retorno_vpfcx);
           premissa.setRetorno_vpl(retorno_vpl);
           
           
           
           premissas.add(premissa);
           
//           System.out.println(premissa);
           
       } catch (IOException e) {
           e.getStackTrace();
       }
       System.out.println(premissas);
       return premissas;
   }

  }


