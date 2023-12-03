package br.edu.unichristus.projetoteste.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.edu.unichristus.projetoteste.data.model.Planilha;
import br.edu.unichristus.projetoteste.repository.PlanilhaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PlanilhaService {
	
	@Autowired
	private PlanilhaRepository repository;
	
	public void savePlanilhaToDatabase(MultipartFile file) {
		if(PlanilhaExcelUploadService.isValidExcelFile(file)) {
			try {
				List<Planilha> planilha = PlanilhaExcelUploadService.getPlanilhaDataFromExcel(file.getInputStream());
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
