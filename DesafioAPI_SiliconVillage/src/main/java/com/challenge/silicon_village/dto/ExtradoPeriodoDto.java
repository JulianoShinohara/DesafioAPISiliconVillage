package com.challenge.silicon_village.dto;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExtradoPeriodoDto {

	@NotNull(message = "O ID da conta é obrigatório.")
	private Long idConta;

	@NotNull
	private Date dataInicio;

	@NotNull
	private Date dataFim;
}