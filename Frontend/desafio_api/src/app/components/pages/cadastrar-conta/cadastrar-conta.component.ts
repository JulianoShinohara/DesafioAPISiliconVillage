import { Component } from '@angular/core';
import { ContaService } from '../../../services/conta.service';
import { MessageService } from '../../../services/message.service';
import { ComunicacaoService } from '../../../services/comunicacao.service';
import { Router } from '@angular/router';
import { Pessoa } from '../../../models/pessoa';
import { Conta } from '../../../models/conta';

@Component({
  selector: 'app-cadastrar-conta',
  standalone: false,
  templateUrl: './cadastrar-conta.component.html',
  styleUrl: './cadastrar-conta.component.scss'
})
export class CadastrarContaComponent {
  btnText: string = 'Cadastrar'
  
    constructor(private contaService: ContaService, 
                private messageService: MessageService, 
                private comunicacaoService: ComunicacaoService, 
                private router: Router
    ) {}
  
    ngOnInit(): void {
        this.comunicacaoService.emitFunction.subscribe(() => {
          console.log("chegou no emit desejado")
        })
    }
  
    cadastraConta(conta: Conta) {
      this.contaService.CriarConta(conta).subscribe(
        (res) => {
          conta = res;
          console.log('Conta cadastrado com sucesso!')
          this.messageService.alert("Conta cadastrada com sucesso!")
          this.router.navigate(['/'])
      },
      (error) => {
        console.error('Erro na requisição:', error);
        this.messageService.alert(
          'Erro desconhecido ao cadastrar Conta.'
        ); 
      });
    }
}
