import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { error } from 'console';
import { PessoaService } from '../../../services/pessoa.service';
import { ContaService } from '../../../services/conta.service';
import { SaldoService } from '../../../services/saldo.service';

@Component({
  selector: 'app-saldo',
  templateUrl: './saldo.component.html',
  styleUrl: './saldo.component.scss'
})
export class SaldoComponent {
  cpf: string = '';  // Armazena o CPF inserido
  saldo: number | null = null;  // Armazena o saldo da conta
  errorMessage: string = '';  // Armazena a mensagem de erro

  constructor(private contaService: ContaService) {}

  // Método para buscar o saldo
  buscarSaldo(): void {
    if (this.cpf.length === 11) {
      this.contaService.buscarSaldoPorCpf(this.cpf).subscribe(
        (data: any) => {
          this.saldo = data.saldo;
          this.errorMessage = '';  // Limpa a mensagem de erro
        },
      );
    } else {
      this.errorMessage = 'Por favor, insira um CPF válido.';
    }
  }
}
