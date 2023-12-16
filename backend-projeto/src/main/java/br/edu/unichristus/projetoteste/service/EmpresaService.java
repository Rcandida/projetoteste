package br.edu.unichristus.projetoteste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.projetoteste.converter.DozerConverter;
import br.edu.unichristus.projetoteste.data.dto.EmpresaDTO;
import br.edu.unichristus.projetoteste.data.model.Empresa;
import br.edu.unichristus.projetoteste.exception.CommonsException;
import br.edu.unichristus.projetoteste.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;

	public EmpresaDTO save(EmpresaDTO dto) {
		if(dto.getNomeEmpresa().length()>150) {
			throw new CommonsException(HttpStatus.BAD_REQUEST, "unichristus.projetoteste.service.empresa.badrequest.exception", "Nome excede 150 caracteres.");
		}
		
		var empresaUpdate = repository.findByNomeEmpresa(dto.getNomeEmpresa());
		
		if(!empresaUpdate.isEmpty()){
			
			if(!dto.getIdEmpresa().equals(empresaUpdate.get().getIdEmpresa()))  {
			
			throw new CommonsException(HttpStatus.CONFLICT, "unichristus.projetoteste.service.empresa.conflict.exception", "Empresa já existe");
		}
		}
		
		if(dto.getIdEmpresa() != null) {
			this.findByIdEmpresa(dto.getIdEmpresa());
		}
		
		var empresa = DozerConverter.parseObject(dto, Empresa.class);
		
		var empresaDTOSaved = DozerConverter.parseObject(repository.save(empresa), EmpresaDTO.class);
		return empresaDTOSaved; 
	}

	public void delete(String id) {
		this.findByIdEmpresa(id);
		repository.deleteById(id);
	}

	public EmpresaDTO findByIdEmpresa(String id) {
		var empresa = repository.findByIdEmpresa(id);
		if (empresa == null || empresa.isEmpty()) {
			throw new CommonsException(HttpStatus.NOT_FOUND, "unichristus.projetoteste.service.empresa.notfound.exception",
					"Empresa não encontrada");
		}
		return DozerConverter.parseObject(empresa.get(), EmpresaDTO.class);

	}

	public List<EmpresaDTO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), EmpresaDTO.class);
	}

}