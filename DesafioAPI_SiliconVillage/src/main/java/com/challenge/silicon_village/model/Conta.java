package com.challenge.silicon_village.model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "conta")
@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conta", nullable = false )
	private Long idConta;

	@OneToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "id_pessoa", updatable = false, nullable = true)
	private Pessoa pessoa;
	
	@Column(name = "saldo", nullable = false )
	private BigDecimal saldo;
	
	@Column(name = "limite_saque_diario", nullable = false )
	private BigDecimal limiteSaqueDiaro;
	
	@Column(name = "flag_ativo", columnDefinition = "boolean default true")
	private Boolean flagAtivo;
	
	@Column(name = "tipo_conta", nullable = false )
	private Long tipoConta;
	
	@Column(name = "data", nullable = false )
	private Date data;
}
