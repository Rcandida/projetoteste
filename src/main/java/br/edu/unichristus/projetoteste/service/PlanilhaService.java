package br.edu.unichristus.projetoteste.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.edu.unichristus.projetoteste.converter.DozerConverter;
import br.edu.unichristus.projetoteste.data.model.Planilha;
import br.edu.unichristus.projetoteste.data.model.Simulacao;
import br.edu.unichristus.projetoteste.repository.PlanilhaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PlanilhaService {
	
	@Autowired
	private PlanilhaRepository repository;
	
	@Autowired
	private SimulacaoService simulacaoService;
	
	
	
	public void savePlanilhaToDatabase(MultipartFile file, String id) {
		if(PlanilhaExcelUploadService.isValidExcelFile(file)) {
			try {
				var simulacao = DozerConverter.parseObject(simulacaoService.findByIdSimulacao(id), Simulacao.class);
				
				List<Planilha> planilha = PlanilhaExcelUploadService.getPlanilhaDataFromExcel(file.getInputStream(), simulacao);
				
				this.repository.saveAll(planilha);
				
			}catch(IOException e) {
				throw new IllegalArgumentException("O arquivo não é válido ");
			}
		}
	}
	
	public List<Planilha> getPlanilha(){
		return repository.findAll();
	}

}
