import { Component, EventEmitter, Output } from '@angular/core';
import { Transacao } from '../../../models/transacao';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ContaService } from '../../../services/conta.service';

@Component({
  selector: 'app-deposito-conta',
  templateUrl: './deposito-conta.component.html',
  styleUrl: './deposito-conta.component.scss'
})
export class DepositoContaComponent {
cpf: string = ''; // CPF digitado
  valorDeposito: number = 0; // Valor de saque
  erro: string = ''; // Mensagem de erro, se houver
  transacao!: Transacao

  constructor(private contaService: ContaService) {}

  // Método para realizar o saque
  realizarDeposito() {
    if (this.valorDeposito <= 0) {
      this.erro = 'O valor do saque deve ser positivo.';
      return;
    }

    this.contaService.realizarDeposito(this.cpf, this.valorDeposito).subscribe(
      (response) => {
        this.transacao = response; // Exibe a transação realizada
        this.erro = '';
        alert('Deposito realizado com sucesso!');
      },
      (error) => {
        if (error.status === 400) {
          this.erro = 'Erro: ' + error.error.message;
        } else {
          this.erro = 'Erro ao realizar o Deposito.';
        }
      }
    );
  }
}
