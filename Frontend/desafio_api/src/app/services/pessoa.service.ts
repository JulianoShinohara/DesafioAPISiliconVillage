import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Pessoa } from '../models/pessoa';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PessoaService {

  private apiUrl = 'http://localhost:8080/pessoa';

  public http: HttpClient;

  constructor(http: HttpClient) {
    this.http = http;
  }

  listAll(): Observable<Pessoa[]> {
    return this.http.get<any>(this.apiUrl, {}).pipe(
      map((data) => data)
    );
  }

  CriarPessoa(pessoa: Pessoa): Observable<Pessoa> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json', // Garante que o tipo seja JSON
    });
    return this.http.post<Pessoa>(this.apiUrl, pessoa, { headers });
  }

  BuscarPessoaPorCpf(cpf: string): Observable<Pessoa> {
    return this.http.get<Pessoa>(`${this.apiUrl}/buscar/${cpf}`);
  }
}

