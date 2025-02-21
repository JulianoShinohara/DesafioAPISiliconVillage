package com.challenge.silicon_village.dto;
import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
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
public class SaqueDto {
    
	@NotNull(message = "O valor do saque não pode ser nulo.")
    @DecimalMin(value = "0.01", message = "O valor do saque deve ser maior que zero.")
    private BigDecimal valorSaque;
}