package br.edu.unichristus.projetoteste.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.edu.unichristus.projetoteste.data.dto.MessageDTO;
import br.edu.unichristus.projetoteste.exception.CommonsException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)// colocar o "callSuper = false" não herda o HashCodeEquals da RuntimeException
@Builder//
@AllArgsConstructor
public class CommonsException extends RuntimeException {
	private static final long serialVersionUID = -4694258578216919456L;
	protected HttpStatus status;
	protected String key;
	protected String text;

	public ResponseEntity<MessageDTO> getMessageError() {
		return ResponseEntity.status(status).body(new MessageDTO(text, key));
	}
}
