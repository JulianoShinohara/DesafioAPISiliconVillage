package com.challenge.silicon_village.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.silicon_village.dto.PessoaDto;
import com.challenge.silicon_village.model.Pessoa;
import com.challenge.silicon_village.service.PessoaService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;
	
	@PostMapping("")
	public ResponseEntity<Pessoa> create(@Valid @RequestBody PessoaDto dto)
	throws Exception { 
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.create(dto));
	}
	
	@GetMapping("")
	public ResponseEntity<List<PessoaDto>> getPessoas() {
		
		try {
			List<PessoaDto> pessoas = pessoaService.findall();
			return ResponseEntity.ok(pessoas);
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@GetMapping("/buscar/{cpf}")
    public ResponseEntity<Pessoa> buscarPessoaPorCpf(@PathVariable("cpf") String cpf) {
		System.out.print("CONTROLLEERRR");

        Pessoa pessoa = pessoaService.buscarPessoaPorCpf(cpf);
        
        if (pessoa != null) {
            return new ResponseEntity<>(pessoa, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
