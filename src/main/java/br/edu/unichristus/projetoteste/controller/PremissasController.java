package br.edu.unichristus.projetoteste.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.edu.unichristus.projetoteste.data.model.Premissas;
import br.edu.unichristus.projetoteste.service.PremissasService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("premissas")
public class PremissasController {
	
	@Autowired
	private PremissasService service;
	
	@Operation(summary = "Cadastra os dados de uma premissas de simulação | role: [USUARIO]", tags = "Premissas")
	@PostMapping("/upload-planilhas-data")
    public ResponseEntity<?> uploadPremissasData(@RequestParam("file")MultipartFile file){
        this.service.savePremissasToDatabase(file);
        return ResponseEntity
                .ok(Map.of("Message" , " Premissas data uploaded and saved to database successfully"));
    }

	@Operation(summary = "Retorna os dados de todas as premissass de simulação | role: [USUARIO]", tags = "Premissas")
    @GetMapping
    public ResponseEntity<List<Premissas>> getPremissas(){
        return new ResponseEntity<>(service.getPremissas(), HttpStatus.FOUND);
    }
}


