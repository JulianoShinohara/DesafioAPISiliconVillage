import { Pessoa } from "./pessoa";

export class Conta {
    idConta!: number;
    pessoa!: Pessoa;
    saldo: number = 0;
    limiteSaqueDiaro!: number;
    flagAtivo: boolean = true;
    tipoConta: number = 0;
    data?: Date;
  }