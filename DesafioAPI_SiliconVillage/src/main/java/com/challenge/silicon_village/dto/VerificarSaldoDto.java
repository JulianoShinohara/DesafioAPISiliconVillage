package com.challenge.silicon_village.dto;
import java.math.BigDecimal;

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
public class VerificarSaldoDto {
    
    private Long idConta;

    private BigDecimal saldo;
}