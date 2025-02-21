import { Component, OnInit } from '@angular/core';
import { Pessoa } from '../../../models/pessoa';
import { PessoaService } from '../../../services/pessoa.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { error } from 'console';
import { MessageService } from '../../../services/message.service';
import { ComunicacaoService } from '../../../services/comunicacao.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cadastrar-pessoa',
  standalone: false,
  templateUrl: './cadastrar-pessoa.component.html',
  styleUrl: './cadastrar-pessoa.component.scss'
})
export class CadastrarPessoaComponent implements OnInit {
  btnText: string = 'Cadastrar'

  constructor(private pessoaService: PessoaService, private messageService: MessageService, 
                                                    private comunicacaoService: ComunicacaoService, 
                                                    private router: Router
  ) {}

  ngOnInit(): void {
      this.comunicacaoService.emitFunction.subscribe(() => {
        console.log("chegou no emit desejado")
      })
  }

  cadastraPessoa(pessoa: Pessoa) {
    this.pessoaService.CriarPessoa(pessoa).subscribe(
      (res) => {
        pessoa = res;
        console.log('Pessoa ${pessoa.nome} cadastrado com sucesso!')
        this.messageService.alert("Pessoa cadastrada com sucesso!")
        this.router.navigate(['/'])
    },
    (error) => {
      console.error('Erro na requisição:', error);
      this.messageService.alert(
        'Erro desconhecido ao cadastrar funcionário.'
      ); 
    });
  }
}
