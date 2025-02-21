package com.challenge.silicon_village.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.silicon_village.dto.PessoaDto;
import com.challenge.silicon_village.model.Pessoa;
import com.challenge.silicon_village.repository.PessoaRepository;


import jakarta.transaction.Transactional;
import lombok.NonNull;

@Service
public class PessoaService{

	@Autowired
	PessoaRepository pessoaRepository;
	
	
	/**
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public Pessoa create(@NonNull PessoaDto dto) throws Exception {
		
		Optional<Pessoa> optPessoa = pessoaRepository.findByCpf(dto.getCpf());

		if (optPessoa.isPresent()) {
			throw new IllegalStateException("Já existe uma pessoa com o CPF fornecido: " + dto.getCpf());
		}
		
		Pessoa pessoa = Pessoa.builder()
				.nome(dto.getNome())
				.cpf(dto.getCpf())
				.dataNascimento(dto.getDataNascimento())
				.build();
		
		return pessoaRepository.save(pessoa);
	
	}
	
	/**
	 * 
	 * @return
	 */
	public List<PessoaDto> findall(){
		List<Pessoa> listPessoa = pessoaRepository.findAll();
		
		return listPessoa.stream().map(pessoa -> PessoaDto.builder()
				.idPessoa(pessoa.getIdPessoa())
				.nome(pessoa.getNome())
				.cpf(pessoa.getCpf())
				.dataNascimento(pessoa.getDataNascimento())
				.build())
				.collect(Collectors.toList());
	}
	
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	public Pessoa buscarPessoaPorCpf(String cpf) {
		Pessoa pessoa = pessoaRepository.findByCpf(cpf)
				.orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
				
        return pessoa;
    }
}
