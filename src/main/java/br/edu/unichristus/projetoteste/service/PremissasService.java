package br.edu.unichristus.projetoteste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.projetoteste.converter.DozerConverter;
import br.edu.unichristus.projetoteste.data.dto.PremissasDTO;
import br.edu.unichristus.projetoteste.data.model.Premissas;
import br.edu.unichristus.projetoteste.data.model.Simulacao;
import br.edu.unichristus.projetoteste.exception.CommonsException;
import br.edu.unichristus.projetoteste.repository.PremissasRepository;

@Service
public class PremissasService {
	
	@Autowired
	private PremissasRepository repository;
	
	@Autowired
	private SimulacaoService simulacaoService;
	
	public PremissasDTO save(PremissasDTO dto) {
		
		var simulacao = DozerConverter.parseObject(simulacaoService.findByIdSimulacao(dto.getIdSimulacao()), Simulacao.class);
		
		if(dto.getIdPremissas() != null) {
			this.findByIdPremissas(dto.getIdPremissas());
		}
		
		var premissas = DozerConverter.parseObject(dto, Premissas.class);
		
		premissas.setSimulacao(simulacao);
		
		var premissasDTOSaved = DozerConverter.parseObject(repository.save(premissas), PremissasDTO.class);
		
		premissasDTOSaved.setIdSimulacao(simulacao.getIdSimulacao());
		
		return premissasDTOSaved; 
	}

	public void delete(String id) {
		this.findByIdPremissas(id);
		repository.deleteById(id);
	}

	public PremissasDTO findByIdPremissas(String id) {
		var premissas = repository.findByIdPremissas(id);
		if (premissas == null || premissas.isEmpty()) {
			throw new CommonsException(HttpStatus.NOT_FOUND, "unichristus.projetoteste.service.premissas.notfound.exception",
					"Premissas não encontrada");
		}
		var dto = DozerConverter.parseObject(premissas.get(), PremissasDTO.class);
		dto.setIdSimulacao(premissas.get().getSimulacao().getIdSimulacao());
		return dto;

	}

	public List<PremissasDTO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), PremissasDTO.class);
	}
	
	

}


