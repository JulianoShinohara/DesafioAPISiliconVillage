package com.challenge.silicon_village.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.challenge.silicon_village.model.Conta;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
public class TransacaoDto {

	@Id
	@GeneratedValue
	private Long idTransacao;
	
	private Conta conta;
	private BigDecimal valor;
	private Date data;
}
