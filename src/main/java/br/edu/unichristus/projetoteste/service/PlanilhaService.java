package br.edu.unichristus.projetoteste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.projetoteste.converter.DozerConverter;
import br.edu.unichristus.projetoteste.data.dto.PlanilhaDTO;
import br.edu.unichristus.projetoteste.data.dto.PremissasDTO;
import br.edu.unichristus.projetoteste.data.model.Planilha;
import br.edu.unichristus.projetoteste.data.model.Premissas;
import br.edu.unichristus.projetoteste.exception.CommonsException;
import br.edu.unichristus.projetoteste.repository.PlanilhaRepository;

@Service
public class PlanilhaService {
	
	@Autowired
	private PlanilhaRepository repository;
	
	@Autowired
	private PremissasService premissasService;
	
	
	public PlanilhaDTO save(PlanilhaDTO dto) {
			
		var premissas = DozerConverter.parseObject(premissasService.findByIdPremissas(dto.getIdPremissas()), Premissas.class);
		
		if(dto.getIdPlanilha() != null) {
			this.findByIdPlanilha(dto.getIdPlanilha());
		}
		
		var planilha = DozerConverter.parseObject(dto, Planilha.class);
		
		planilha.setPremissas(premissas);
		
		var planilhaDTOSaved = DozerConverter.parseObject(repository.save(planilha), PlanilhaDTO.class);
		
		planilhaDTOSaved.setIdPremissas(premissas.getIdPremissas());
		
		return planilhaDTOSaved; 
	}

	public void delete(String id) {
		this.findByIdPlanilha(id);
		repository.deleteById(id);
	}

	public PlanilhaDTO findByIdPlanilha(String id) {
		var planilha = repository.findByIdPlanilha(id);
		if (planilha == null || planilha.isEmpty()) {
			throw new CommonsException(HttpStatus.NOT_FOUND, "unichristus.projetoteste.service.planilha.notfound.exception",
					"Planilha não encontrada");
		}
		
		var dto = DozerConverter.parseObject(planilha.get(), PlanilhaDTO.class);
		dto.setIdPremissas(planilha.get().getPremissas().getIdPremissas());
		return dto;

	}

	public List<PlanilhaDTO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), PlanilhaDTO.class);
	}
	
	

}
