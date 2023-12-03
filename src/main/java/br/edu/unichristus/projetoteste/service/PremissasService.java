package br.edu.unichristus.projetoteste.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.edu.unichristus.projetoteste.data.model.Premissas;
import br.edu.unichristus.projetoteste.repository.PremissasRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PremissasService {
	
	@Autowired
	private PremissasRepository repository;

	public void savePremissasToDatabase(MultipartFile file){
		if(PremissasExcelUploadService.isValidExcelFile(file)){
            try {
                List<Premissas> premissas = PremissasExcelUploadService.getPremissasDataFromExcel(file.getInputStream());
                this.repository.saveAll(premissas);
            } catch (IOException e) {
                throw new IllegalArgumentException("O arquivo não é válido");
            }
        }}
    
////        if(UploadPremissas.isValidExcelFile(file)){
//            try {
////                List<Premissas> premissas = UploadPremissas.LerPlanilha(file);
//                this.premissasRepository.saveAll(premissas);
//            } catch (IOException e) {
//                throw new IllegalArgumentException("The file is not a valid excel file");
//            }
//        }
   

    public List<Premissas> getPremissas(){
        return repository.findAll();
    }
}
	
