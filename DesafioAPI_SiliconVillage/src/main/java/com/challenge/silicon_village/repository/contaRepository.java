package com.challenge.silicon_village.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.silicon_village.model.Conta;
import com.challenge.silicon_village.model.Pessoa;

@Repository
public interface contaRepository extends JpaRepository<Conta, Long> {

	Optional<Conta> findByPessoaCpf(String cpf);

	Optional<Conta> findByPessoaIdPessoa(Long idPessoa);}
