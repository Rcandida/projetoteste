package br.edu.unichristus.projetoteste.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.edu.unichristus.projetoteste.converter.DozerConverter;
import br.edu.unichristus.projetoteste.data.dto.PremissasDTO;
import br.edu.unichristus.projetoteste.data.model.Premissas;
import br.edu.unichristus.projetoteste.data.model.Simulacao;
import br.edu.unichristus.projetoteste.exception.CommonsException;
import br.edu.unichristus.projetoteste.repository.PremissasRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PremissasService {
	
	@Autowired
	private PremissasRepository repository;
	
	@Autowired
	private SimulacaoService simulacaoService;

	public void savePremissasToDatabase(MultipartFile file, String id){
		if(PremissasExcelUploadService.isValidExcelFile(file)){
            try {
            	var simulacao = DozerConverter.parseObject(simulacaoService.findByIdSimulacao(id), Simulacao.class);
                
            	List<Premissas> premissas = PremissasExcelUploadService.getPremissasDataFromExcel(file.getInputStream(), simulacao);
                
            	this.repository.saveAll(premissas);
            	
            } catch (IOException e) {
                throw new IllegalArgumentException("O arquivo não é válido");
            }
        }}
    

	public PremissasDTO findById(String id) {
		var premissas = repository.findById(id);
		
		if(premissas == null || premissas.isEmpty()) {
			throw new CommonsException(HttpStatus.NOT_FOUND, "unichristus.projetoupload.service.premissas.notfound.exception", "Premissas não localizadas");
		}
		return DozerConverter.parseObject(premissas.get(), PremissasDTO.class);
		
	}

	
	
}
	

	
	

//    public List<Premissas> getPremissas(){
//        return repository.findAll();
//    }
//    
//    public PremissasDTO findById(String id) {
//		var premissas = repository.findById(id);
//		
//		if(premissas == null || premissas.isEmpty()) {
//			throw new CommonsException(HttpStatus.NOT_FOUND, "unichristus.projetoupload.service.premissas.notfound.exception", "Premissas não localizadas");
//		}
//		return DozerConverter.parseObject(premissas.get(), PremissasDTO.class);
//		
//	}
//
//	public Object findByIdPremissas(String idPremissas) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//}
//	
