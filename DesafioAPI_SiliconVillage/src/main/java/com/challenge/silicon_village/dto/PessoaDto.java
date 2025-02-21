package com.challenge.silicon_village.dto;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDto {
	
	@Id
	@GeneratedValue
	private Long idPessoa;
	
	private String nome;
	private String cpf;
	private Date dataNascimento;

}
