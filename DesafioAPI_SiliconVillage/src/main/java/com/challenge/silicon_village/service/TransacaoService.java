package com.challenge.silicon_village.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.silicon_village.model.Transacao;
import com.challenge.silicon_village.repository.TransacaoRepository;

@Service
public class TransacaoService {

	@Autowired
	private TransacaoRepository transacaoRepository;

	// Método para buscar transações de uma conta
	public List<Transacao> buscarTransacoesPorConta(String cpf) {
		return transacaoRepository.findByContaPessoaCpf(cpf);
	}
	
	public List<Transacao> buscarTransacoesPorPeriodo(String cpf, LocalDateTime dataInicio, LocalDateTime dataFim) {
        return transacaoRepository.findByCpfAndPeriodo(cpf, dataInicio, dataFim);
    }
}
