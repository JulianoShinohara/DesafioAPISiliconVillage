package com.challenge.silicon_village.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.silicon_village.dto.ContaDto;
import com.challenge.silicon_village.dto.DepositoDto;
import com.challenge.silicon_village.dto.ExtradoPeriodoDto;
import com.challenge.silicon_village.dto.PessoaDto;
import com.challenge.silicon_village.dto.SaqueDto;
import com.challenge.silicon_village.dto.VerificarSaldoDto;
import com.challenge.silicon_village.model.Conta;
import com.challenge.silicon_village.model.Pessoa;
import com.challenge.silicon_village.model.Transacao;
import com.challenge.silicon_village.repository.PessoaRepository;
import com.challenge.silicon_village.repository.TransacaoRepository;
import com.challenge.silicon_village.repository.contaRepository;

import jakarta.transaction.Transactional;
import lombok.NonNull;

@Service
public class ContaService {

	@Autowired
	contaRepository ContaRepository;

	@Autowired
	PessoaRepository pessoaRepository;

	@Autowired
	TransacaoRepository transacaoRepository;
	
	/**
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 * 
	 * Implementar path que realiza a criação de uma conta;

	 */
	@Transactional
	public Conta create(@NonNull ContaDto dto) throws Exception {
		
		Pessoa pessoa = null;
		
		Optional<Pessoa> optPessoa = Optional.empty();
		
		if (null != dto.getPessoa().getIdPessoa()) {
			optPessoa = pessoaRepository.findById(dto.getPessoa().getIdPessoa());
		} 
		
		if (optPessoa.isEmpty()) {
			throw new IllegalStateException("Cpf não está cadastrado!!");
		}
		
		pessoa = optPessoa.get();
		
		Optional<Conta> optConta = ContaRepository.findByPessoaIdPessoa(pessoa.getIdPessoa());

		if (optConta.isPresent()) {
			throw new IllegalStateException("Já existe uma conta cadastrada!!");
		}
		
		Conta conta = Conta.builder()
				.pessoa(pessoa)
				.saldo(dto.getSaldo())
				.limiteSaqueDiaro(dto.getLimiteSaqueDiaro())
				.tipoConta(dto.getTipoConta())
				.flagAtivo(dto.getFlagAtivo())
				.build();
		
		return ContaRepository.save(conta);
	
	}
	
	/**
	 * 
	 * @return
	 */
	public List<ContaDto> findall(){
		List<Conta> listConta = ContaRepository.findAll();
		
		return listConta.stream().map(conta -> ContaDto.builder()
				.idConta(conta.getIdConta())
				.pessoa(conta.getPessoa())
				.saldo(conta.getSaldo())
				.limiteSaqueDiaro(conta.getLimiteSaqueDiaro())
				.flagAtivo(conta.getFlagAtivo())
				.tipoConta(conta.getTipoConta())
				.data(conta.getData())
				.build())
				.collect(Collectors.toList());
	}
	
	
	/**
	 * 
	 * @param dto
	 * @param valorDeposito
	 * @return
	 * @throws Exception
	 * 
	 * Implementar path que realiza operação de depósito em uma conta;
	 */
	 @Transactional
	    public Transacao depositarPorCpf(String cpf, DepositoDto dto) {
	        Optional<Conta> optConta = ContaRepository.findByPessoaCpf(cpf);

	        if(optConta.isEmpty()) {
	        	throw new IllegalArgumentException("Conta não existe nesse cpf.");
	        }
	        
	        Conta conta = optConta.get();
	        
	        	
            conta.setSaldo(conta.getSaldo().add(dto.getValorDeposito()));

            ContaRepository.save(conta);

            Transacao transacao = new Transacao().builder()
            		.conta(conta)
            		.valor(dto.getValorDeposito())
            		.data(new Date())
            		.build();
            
            transacaoRepository.save(transacao);

            return transacao;
	    }
	
	/**
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 * 
	 * Implementar path que realiza operação de consulta de saldo em determinada conta;
	 */
	@Transactional
	public Conta buscarSaldoPorCpf(String cpf) {
        Optional<Pessoa> optPessoa = pessoaRepository.findByCpf(cpf);
        
        if(optPessoa.isEmpty()) {
        	throw new IllegalArgumentException("Pessoa não encontrada.");
        }
        
    	Pessoa pessoa = optPessoa.get();
    	Optional<Conta> optConta = ContaRepository.findByPessoaIdPessoa(pessoa.getIdPessoa());
    	
    	if(optConta.isEmpty()) {
    		throw new IllegalArgumentException("Conta não encontrada.");
    	}
        Conta conta = optConta.get();
        return conta;
    }
	
	 @Transactional
    public Transacao realizarSaque(String cpf, SaqueDto dto) {
        Optional<Conta> optConta = ContaRepository.findByPessoaCpf(cpf);

        if(optConta.isEmpty()) {
        	throw new IllegalArgumentException("Conta não existe nesse cpf.");
        }
        
        Conta conta = optConta.get();
        
        if (conta != null) {
            // Verificar se o valor do saque é maior que o limite diário
            if (dto.getValorSaque().compareTo(conta.getLimiteSaqueDiaro()) > 0) {
                throw new IllegalArgumentException("O valor do saque excede o limite diário.");
            }

            // Verificar se o saldo é suficiente para o saque
            if (conta.getSaldo().compareTo(dto.getValorSaque()) >= 0) {
                conta.setSaldo(conta.getSaldo().subtract(dto.getValorSaque()));
                ContaRepository.save(conta);

                Transacao transacao = new Transacao().builder()
                		.conta(conta)
                		.valor(dto.getValorSaque())
                		.data(new Date())
                		.build();
                
                // Salvar a transação no banco de dados
                transacaoRepository.save(transacao);

                return transacao;
            } else {
                throw new IllegalArgumentException("Saldo insuficiente.");
            }
        } else {
            throw new IllegalArgumentException("Conta não encontrada.");
        }
    }
	
	/**
	 * 
	 * @param idConta
	 * @return
	 * @throws Exception
	 * 
	 * * Implementar path que recupera o extrato de transações de uma conta;
	 */
	@Transactional
	public List<Transacao> getExtrato(Long idConta) throws Exception {
        // Busca as transações associadas à conta
        List<Transacao> transacoes = transacaoRepository.findByContaIdConta(idConta);

        if (transacoes.isEmpty()) {
            throw new IllegalStateException("Nenhuma transação encontrada para esta conta.");
        }

        return transacoes;
    }
	
	/**
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 * 
	 * Implementar extrato por período;
	 */
	public List<Transacao> extratoPorPeriodo(ExtradoPeriodoDto dto) throws Exception {
        List<Transacao> transacoes = transacaoRepository.findByContaIdContaAndDataBetween(dto.getIdConta(), dto.getDataInicio(), dto.getDataFim());

        if (transacoes.isEmpty()) {
            throw new IllegalStateException("Nenhuma transação encontrada para esta conta no período especificado.");
        }

        return transacoes;
    }
	
	/**
	 * 
	 * @param id
	 * @param flagAtivo
	 * 
	 * Path para Bloquear e Desbloquear conta
	 */
	public void alterarStatus(Long idConta, boolean flagAtivo) {
	    Conta conta = ContaRepository.findById(idConta)
	                  .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
	    conta.setFlagAtivo(flagAtivo);
	    ContaRepository.save(conta);
	}

}
