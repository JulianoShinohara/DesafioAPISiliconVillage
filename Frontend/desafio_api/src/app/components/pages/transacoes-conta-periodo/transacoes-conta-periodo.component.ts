import { Component } from '@angular/core';
import { TransacaoService } from '../../../services/transacao.service';
import { Transacao } from '../../../models/transacao';

@Component({
  selector: 'app-transacoes-conta-periodo',
  templateUrl: './transacoes-conta-periodo.component.html',
  styleUrl: './transacoes-conta-periodo.component.scss'
})
export class TransacoesContaPeriodoComponent {
  cpf: string = '';
  dataInicio: string = '';
  dataFim: string = '';
  transacoes: Transacao[] = [];
  errorMessage: string = '';

  constructor(private transacaoService: TransacaoService) {}

  buscarTransacoesPorPeriodo() {
    if (this.cpf && this.dataInicio && this.dataFim) {
      this.transacaoService.buscarTransacoesPorPeriodo(this.cpf, this.dataInicio, this.dataFim).subscribe(
        (response) => {
          this.transacoes = response;
          this.errorMessage = '';
          alert('Listagem realizada com sucesso!');
        },
        (error) => {
          this.errorMessage = 'Erro ao buscar transações. Verifique os dados e tente novamente.';
          console.error('Erro ao buscar transações:', error);
        }
      );
    }
  }
}
