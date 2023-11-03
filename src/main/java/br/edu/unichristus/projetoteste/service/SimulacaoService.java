package br.edu.unichristus.projetoteste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.projetoteste.converter.DozerConverter;
import br.edu.unichristus.projetoteste.data.dto.SimulacaoDTO;
import br.edu.unichristus.projetoteste.data.model.Simulacao;
import br.edu.unichristus.projetoteste.exception.CommonsException;
import br.edu.unichristus.projetoteste.repository.SimulacaoRepository;

@Service
public class SimulacaoService {
	
	@Autowired
	private SimulacaoRepository repository;
	
	public SimulacaoDTO save(SimulacaoDTO dto) {
		if(dto.getIdSimulacao() != null) {
			this.findByIdSimulacao(dto.getIdSimulacao());
		}
		var simulacao = DozerConverter.parseObject(dto, Simulacao.class);
		
		var simulacaoDTOsaved = DozerConverter.parseObject(repository.save(simulacao), SimulacaoDTO.class);
		return simulacaoDTOsaved;
	}
	
	public void delete(String id) {
		this.findByIdSimulacao(id);
		repository.deleteById(id);
	}
	
	public SimulacaoDTO findByIdSimulacao(String id) {
		var simulacao = repository.findByIdSimulacao(id);
		if(simulacao == null || simulacao.isEmpty()) {
			throw new CommonsException(HttpStatus.NOT_FOUND, "unichristus.projetoteste.service.simulacao.notfound.exception", "Simulacao não localizada");

		}
		return DozerConverter.parseObject(simulacao.get(), SimulacaoDTO.class);
	}
	
	public List<SimulacaoDTO> findAll(){
		return DozerConverter.parseListObjects(repository.findAll(), SimulacaoDTO.class);

	}


}