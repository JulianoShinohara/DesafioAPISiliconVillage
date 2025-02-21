import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Conta } from '../models/conta';
import { Transacao } from '../models/transacao';

@Injectable({
  providedIn: 'root'
})
export class ContaService {

   private apiUrl = 'http://localhost:8080/conta';
  
    public http: HttpClient;
  
    constructor(http: HttpClient) {
      this.http = http;
    }
  
    listAll(): Observable<Conta[]> {
      return this.http.get<any>(this.apiUrl, {}).pipe(
        map((data) => data)
      );
    }
  
    CriarConta(conta: Conta): Observable<Conta> {
      const headers = new HttpHeaders({
        'Content-Type': 'application/json', // Garante que o tipo seja JSON
      });
      return this.http.post<Conta>(this.apiUrl, conta, { headers });
    }

    alterarStatus(idConta: number, flagAtivo: boolean): Observable<void> {
      return this.http.put<void>(`${this.apiUrl}/${idConta}/status`, { flagAtivo });
    }

    buscarSaldoPorCpf(cpf: string): Observable<any> {
      return this.http.get<any>(`${this.apiUrl}/saldo/${cpf}`);
    }
  
  realizarSaque(cpf: string, valorSaque: number): Observable<Transacao> {
    const body = {
      valorSaque: valorSaque
    };
    return this.http.post<Transacao>(`${this.apiUrl}/saque/${cpf}`, body);
  }

   realizarDeposito(cpf: string, valorDeposito: number): Observable<any> {
    const body = {
      valorDeposito: valorDeposito
    };
    return this.http.post<any>(`${this.apiUrl}/deposito/${cpf}`, body);
  }
}
