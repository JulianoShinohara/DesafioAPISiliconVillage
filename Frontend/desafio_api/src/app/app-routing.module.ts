import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/pages/home/home.component';
import { CadastrarPessoaComponent } from './components/pages/cadastrar-pessoa/cadastrar-pessoa.component';
import { PessoasComponent } from './components/pages/pessoas/pessoas.component';
import { ContasComponent } from './components/pages/contas/contas.component';
import { CadastrarContaComponent } from './components/pages/cadastrar-conta/cadastrar-conta.component';
import { SaldoComponent } from './components/pages/saldo/saldo.component';
import { SaqueContaComponent } from './components/pages/saque-conta/saque-conta.component';
import { DepositoContaComponent } from './components/pages/deposito-conta/deposito-conta.component';
import { TransacoesContaComponent } from './components/pages/transacoes-conta/transacoes-conta.component';
import { TransacoesContaPeriodoComponent } from './components/pages/transacoes-conta-periodo/transacoes-conta-periodo.component';

const routes: Routes = [
  {path: '', component:HomeComponent},
  {path: 'pessoa', component:PessoasComponent},
  {path: 'pessoa/cadastro', component:CadastrarPessoaComponent},
  {path: 'conta', component:ContasComponent},
  {path: 'conta/cadastro', component:CadastrarContaComponent},
  {path: 'conta/saque', component:SaqueContaComponent},
  {path: 'conta/deposito', component:DepositoContaComponent},
  {path: 'saldo', component:SaldoComponent},
  {path: 'transacoes', component:TransacoesContaComponent},
  {path: 'transacoes/periodo', component:TransacoesContaPeriodoComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
