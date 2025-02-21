package com.challenge.silicon_village.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.challenge.silicon_village.model.Pessoa;

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
public class ContaDto {
	
	@Id
	@GeneratedValue
	private Long idConta;
	
	private Pessoa pessoa;
	private BigDecimal saldo;
	private BigDecimal limiteSaqueDiaro;
	private Boolean flagAtivo;
	private Long tipoConta;
	private Date data;
}
