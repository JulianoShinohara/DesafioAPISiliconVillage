package com.challenge.silicon_village.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.silicon_village.dto.ContaDto;
import com.challenge.silicon_village.dto.DepositoDto;
import com.challenge.silicon_village.dto.ExtradoPeriodoDto;
import com.challenge.silicon_village.dto.PessoaDto;
import com.challenge.silicon_village.dto.SaqueDto;
import com.challenge.silicon_village.dto.TransacaoDto;
import com.challenge.silicon_village.model.Conta;
import com.challenge.silicon_village.model.Transacao;
import com.challenge.silicon_village.service.ContaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/conta")
public class ContaController {

	@Autowired
	ContaService contaService;

	/**
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<Conta> create(@Valid @RequestBody ContaDto dto) throws Exception {

		return ResponseEntity.status(HttpStatus.CREATED).body(contaService.create(dto));
	}
	
	@GetMapping("")
	public ResponseEntity<List<ContaDto>> getContas() {
		
		try {
			List<ContaDto> pessoas = contaService.findall();
			return ResponseEntity.ok(pessoas);
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	/**
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/deposito/{cpf}")
    public ResponseEntity<Transacao> depositar(@PathVariable String cpf, @RequestBody DepositoDto dto) {
        Transacao transacao = contaService.depositarPorCpf(cpf, dto);
        return ResponseEntity.ok(transacao);
    }

	/**
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/saldo/{cpf}")
    public Conta consultarSaldo(@PathVariable String cpf) {
        return contaService.buscarSaldoPorCpf(cpf);
        
    }
	
	/**
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@PostMapping("saque/{cpf}")
	public ResponseEntity<Transacao> realizarSaque(
	    @PathVariable String cpf, 
	    @RequestBody @Valid SaqueDto dto) {
	    
	    // Seu código para realizar o saque aqui
	    Transacao transacao = contaService.realizarSaque(cpf, dto);
	    return ResponseEntity.ok(transacao);
	}
	
	/**
	 * 
	 * @param idConta
	 * @return
	 */
	@GetMapping("/{idConta}/extrato")
    public ResponseEntity<List<Transacao>> getExtrato(@PathVariable(name = "idConta", required = true) Long idConta) {
        try {
            List<Transacao> extrato = contaService.getExtrato(idConta);
            return ResponseEntity.ok(extrato);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
	
	/**
	 * 
	 * @param idConta
	 * @param dataInicio
	 * @param dataFim
	 * @return
	 */
	@PostMapping("/extrato-periodo")
    public ResponseEntity<List<Transacao>> getExtratoPorPeriodo(@Valid @RequestBody ExtradoPeriodoDto dto) {
        try {
            List<Transacao> extrato = contaService.extratoPorPeriodo(dto);
            return ResponseEntity.ok(extrato);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
	
	/**
	 * 
	 * @param id
	 * @param requestBody
	 * @return
	 */
	@PutMapping("/{idConta}/status")
	public ResponseEntity<Void> alterarStatusConta(@PathVariable Long idConta, @RequestBody Map<String, Boolean> requestBody) {
	    boolean flagAtivo = requestBody.get("flagAtivo");
	    contaService.alterarStatus(idConta, flagAtivo);
	    return ResponseEntity.ok().build();
	}
	
	

}
