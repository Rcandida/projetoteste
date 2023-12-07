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

import br.edu.unichristus.projetoteste.data.model.Planilha;
import br.edu.unichristus.projetoteste.service.PlanilhaService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("planilha")
public class PlanilhaController {
	
	@Autowired
	private PlanilhaService service;
	
	@Operation(summary = "Cadastra os dados de uma planilha de simulação | role: [USUARIO]", tags = "Planilha")
	@PostMapping("/upload-planilhas-data")
    public ResponseEntity<?> uploadPlanilhaData(@RequestParam("file")MultipartFile file, String id){
        this.service.savePlanilhaToDatabase(file, id);
        return ResponseEntity
                .ok(Map.of("Message" , "Dados da planilha gravados com sucesso!"));
    }

	@Operation(summary = "Retorna os dados de todas as planilhas de simulação | role: [USUARIO]", tags = "Planilha")
    @GetMapping
    public ResponseEntity<List<Planilha>> getPlanilha(){
        return new ResponseEntity<>(service.getPlanilha(), HttpStatus.FOUND);
    }
}


