import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Conta } from '../../../models/conta';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { PessoaService } from '../../../services/pessoa.service';
import { Pessoa } from '../../../models/pessoa';

@Component({
  selector: 'app-form-conta',
  templateUrl: './form-conta.component.html',
  styleUrl: './form-conta.component.scss'
})
export class FormContaComponent implements OnInit {
  @Output() onSubmit = new EventEmitter<Conta>();
  @Input() btnText!: string;

  constructor(private pessoaService: PessoaService){}
  pessoaForm!: FormGroup;
  contaForm!: FormGroup;
  pessoa?: Pessoa;
  
  ngOnInit(): void {
  this.ValidarFormConta();
  }

  ValidarFormConta(){
    this.pessoaForm = new FormGroup({
      cpf: new FormControl('', [Validators.required, Validators.pattern('[0-9]{11}')])
    });

    this.contaForm = new FormGroup({
      idConta: new FormControl(''),
      flagAtivo: new FormControl(true),
      saldo: new FormControl('', [Validators.required]),
      limiteSaqueDiaro: new FormControl('', [Validators.required]),
      tipoConta: new FormControl('', [Validators.required]),
      pessoa: new FormControl(null, [Validators.required]),
    });
  }

  // Método para buscar pessoa pelo CPF
  buscarPessoaPorCpf(): void {
    const cpf = this.pessoaForm.get('cpf')?.value;
    if (cpf && cpf.length === 11) {
      this.pessoaService.BuscarPessoaPorCpf(cpf).subscribe((
        pessoa: Pessoa) => {
        this.pessoaForm.patchValue({
          idPessoa: pessoa.idPessoa,
          nome: pessoa.nome,
          cpf: pessoa.cpf
        });
        this.pessoa = pessoa;
        this.contaForm.patchValue({
          pessoa: pessoa
        });
      }, (error: any) => {
        console.error('Pessoa não encontrada', error);
      });
    }
  }

  submit(){
    if(this.contaForm.invalid){
      console.log("Nao entrou")
      return;
    }
    this.onSubmit.emit(this.contaForm.value);
  }
}
