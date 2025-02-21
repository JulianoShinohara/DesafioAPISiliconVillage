import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SaldoService {

  private baseUrl = 'http://localhost:8080/conta';

  constructor(private http: HttpClient) {}

  buscarSaldoPorCpf(cpf: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/saldo/${cpf}`);
  }
}
