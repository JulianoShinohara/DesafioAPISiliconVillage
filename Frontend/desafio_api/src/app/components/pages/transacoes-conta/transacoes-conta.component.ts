import { Component } from '@angular/core';
import { Transacao } from '../../../models/transacao';
import { TransacaoService } from '../../../services/transacao.service';

@Component({
  selector: 'app-transacoes-conta',
  templateUrl: './transacoes-conta.component.html',
  styleUrl: './transacoes-conta.component.scss'
})
export class TransacoesContaComponent {

  cpf: string = '';
  transacoes: Transacao[] = [];
  errorMessage: string = '';

  constructor(private transacaoService: TransacaoService) { }

  ngOnInit(): void { }

  buscarTransacoes() {
    if (this.cpf) {
      console.log(this.cpf, "entrou no buscar");
      this.transacaoService.buscarTransacoesPorCpf(this.cpf).subscribe(
        (response) => {
          this.transacoes = response;
          this.errorMessage = '';
          console.log('Transações recebidas:', this.transacoes); // Adicionando log para depuração
          alert('Listagem realizada com sucesso!');
        },
        (error) => {
          this.errorMessage = 'Erro ao buscar transações. Verifique o CPF e tente novamente.';
          console.error('Erro ao buscar transações:', error);
        }
      );
    }
  }
}
