import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Transacao } from '../models/transacao';

@Injectable({
  providedIn: 'root'
})
export class TransacaoService {
  private apiUrl = 'http://localhost:8080/transacoes';

  constructor(private http: HttpClient) { }

  // Método para buscar transações por CPF
  buscarTransacoesPorCpf(cpf: string): Observable<Transacao[]> {
    return this.http.get<Transacao[]>(`${this.apiUrl}/${cpf}`);
  }

  buscarTransacoesPorPeriodo(cpf: string, dataInicio: string, dataFim: string): Observable<Transacao[]> {
    const url = `${this.apiUrl}/periodo?cpf=${cpf}&dataInicio=${dataInicio}&dataFim=${dataFim}`;
    return this.http.get<Transacao[]>(url);
  }

}
