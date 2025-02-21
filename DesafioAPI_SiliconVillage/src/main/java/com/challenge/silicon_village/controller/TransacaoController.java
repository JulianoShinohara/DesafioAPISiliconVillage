package com.challenge.silicon_village.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.silicon_village.model.Transacao;
import com.challenge.silicon_village.service.ContaService;
import com.challenge.silicon_village.service.TransacaoService;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

	@Autowired
	private TransacaoService transacaoService;

	@Autowired
	private ContaService contaService;

	// Endpoint para buscar todas as transações de uma pessoa, buscando pelo CPF
	@GetMapping("/{cpf}")
	public List<Transacao> buscarTransacoesPorCpf(@PathVariable String cpf) {
		return transacaoService.buscarTransacoesPorConta(cpf);
	}
	
	@GetMapping("/periodo")
    public List<Transacao> buscarTransacoesPorPeriodo(
            @RequestParam String cpf,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim) {

        return transacaoService.buscarTransacoesPorPeriodo(cpf, dataInicio, dataFim);
    }
}
