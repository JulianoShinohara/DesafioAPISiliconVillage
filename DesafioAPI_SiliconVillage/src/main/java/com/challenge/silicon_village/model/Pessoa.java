package com.challenge.silicon_village.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "pessoa")
@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "id_pessoa", updatable = false, nullable = true)
	private Long idPessoa;
	
	@Column(name = "nome", length = 255, nullable = false )
	private String nome;

	@Column(name = "cpf", length = 14, nullable = false )
	private String cpf;
	
	@Column(name = "data_nascimento", nullable = false )
	private Date dataNascimento;

}
