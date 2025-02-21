import { Component } from '@angular/core';
import { Conta } from '../../../models/conta';
import { ContaService } from '../../../services/conta.service';

@Component({
  selector: 'app-contas',
  templateUrl: './contas.component.html',
  styleUrl: './contas.component.scss'
})
export class ContasComponent {

  contas: Conta[] = [];
  
    constructor(private contaService: ContaService){
      this.findAll();
    }
  
    findAll(){
      this.contaService.listAll().subscribe({
        next: (data) => {
          this.contas = data;
        },
      })
    };

    alterarStatusConta(conta: Conta): void {
      // Alterna entre ativo e inativo
      const novaConta = { ...conta, flagAtivo: !conta.flagAtivo };
  
      this.contaService.alterarStatus(novaConta.idConta, novaConta.flagAtivo).subscribe({
        next: () => {
          conta.flagAtivo = novaConta.flagAtivo; // Atualiza a tabela imediatamente
        },
        error: (err) => {
          console.error('Erro ao alterar status da conta', err);
        },
      });
    }
}