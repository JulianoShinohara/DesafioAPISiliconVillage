import { Component } from '@angular/core';
import { ContaService } from '../../../services/conta.service';
import { Transacao } from '../../../models/transacao';

@Component({
  selector: 'app-saque-conta',
  templateUrl: './saque-conta.component.html',
  styleUrl: './saque-conta.component.scss'
})
export class SaqueContaComponent {
  cpf: string = ''; // CPF digitado
  valorSaque: number = 0; // Valor de saque
  erro: string = ''; // Mensagem de erro, se houver
  transacao!: Transacao

  constructor(private contaService: ContaService) {}

  // Método para realizar o saque
  realizarSaque() {
    if (this.valorSaque <= 0) {
      this.erro = 'O valor do saque deve ser positivo.';
      return;
    }

    this.contaService.realizarSaque(this.cpf, this.valorSaque).subscribe(
      (response) => {
        this.transacao = response; // Exibe a transação realizada
        this.erro = '';
        alert('Saque realizado com sucesso!');
      },
      (error) => {
        if (error.status === 400) {
          this.erro = 'Erro: ' + error.error.message;
        } else {
          this.erro = 'Erro ao realizar o saque. Verifique se o saldo é suficiente.';
        }
      }
    );
  }
}
