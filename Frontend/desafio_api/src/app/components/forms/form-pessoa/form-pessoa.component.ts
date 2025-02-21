import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Pessoa } from '../../../models/pessoa';


@Component({
  selector: 'app-form-pessoa',
  templateUrl: './form-pessoa.component.html',
  styleUrl: './form-pessoa.component.scss'
})
export class FormPessoaComponent implements OnInit{
  @Output() onSubmit = new EventEmitter<Pessoa>();
  @Input() btnText!: string;
  
  pessoaForm!: FormGroup;
  
   ngOnInit(): void {
   this.ValidarForm();
  }

  ValidarForm(){
     // Inicialize o FormGroup com os controles
     this.pessoaForm = new FormGroup({
      idPessoa: new FormControl(''),
      nome: new FormControl('', [Validators.required]),
      cpf: new FormControl('', [Validators.required]), 
      dataNascimento: new FormControl('', [Validators.required]), 
    });
  }

  submit(){
    if(this.pessoaForm.invalid){
      console.log("Nao entrou")
      return;
    }
    this.onSubmit.emit(this.pessoaForm.value);
  }
}
