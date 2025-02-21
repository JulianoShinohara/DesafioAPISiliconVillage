package com.challenge.silicon_village.dto;
import java.math.BigDecimal;

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
public class DepositoDto {
    
    @NotNull(message = "O valor do depósito não pode ser nulo.")
    private BigDecimal valorDeposito;
}