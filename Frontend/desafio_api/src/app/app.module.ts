import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './components/footer/footer.component';
import { FormPessoaComponent } from './components/forms/form-pessoa/form-pessoa.component';
import { HeaderComponent } from './components/header/header.component';
import { MessageComponent } from './components/message/message.component';
import { CadastrarContaComponent } from './components/pages/cadastrar-conta/cadastrar-conta.component';
import { CadastrarPessoaComponent } from './components/pages/cadastrar-pessoa/cadastrar-pessoa.component';
import { ContasComponent } from './components/pages/contas/contas.component';
import { HomeComponent } from './components/pages/home/home.component';
import { PessoasComponent } from './components/pages/pessoas/pessoas.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { PessoaService } from './services/pessoa.service';
import { FormContaComponent } from './components/forms/form-conta/form-conta.component';
import { SaldoComponent } from './components/pages/saldo/saldo.component';
import { SaqueContaComponent } from './components/pages/saque-conta/saque-conta.component';
import { DepositoContaComponent } from './components/pages/deposito-conta/deposito-conta.component';
import { TransacoesContaComponent } from './components/pages/transacoes-conta/transacoes-conta.component';
import { TransacoesContaPeriodoComponent } from './components/pages/transacoes-conta-periodo/transacoes-conta-periodo.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    PessoasComponent,
    CadastrarPessoaComponent,
    SidebarComponent,
    FormPessoaComponent,
    ContasComponent,
    MessageComponent,
    CadastrarContaComponent,
    FormContaComponent,
    SaldoComponent,
    SaqueContaComponent,
    DepositoContaComponent,
    TransacoesContaComponent,
    TransacoesContaPeriodoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    FontAwesomeModule,
    ReactiveFormsModule
  ],
  providers: [
    provideClientHydration(),
    PessoaService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
