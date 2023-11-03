package br.edu.unichristus.projetoteste.data.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.edu.unichristus.projetoteste.data.dto.MessageDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"message", "key"})//para manter a ordem "message" e depois "key" mesmo que alguém mude a ordem.
public class MessageDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;// para se comunicar com quem está consumindo a API
	private String key; // para se comunicar com quem está consumindo a API. Key é para criar uma chave única para a message

}
