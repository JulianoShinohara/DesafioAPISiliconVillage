import { Component } from '@angular/core';
import { PessoaService } from '../../../services/pessoa.service';
import { Pessoa } from '../../../models/pessoa';

@Component({
  selector: 'app-pessoas',
  standalone: false,
  templateUrl: './pessoas.component.html',
  styleUrl: './pessoas.component.scss'
})
export class PessoasComponent {

  pessoas: Pessoa[] = [];

  constructor(private pessoaService: PessoaService){
    this.findAll();
  }

  findAll(){
    this.pessoaService.listAll().subscribe({
      next: (data) => {
        this.pessoas = data;
      },
    })
  };
}
