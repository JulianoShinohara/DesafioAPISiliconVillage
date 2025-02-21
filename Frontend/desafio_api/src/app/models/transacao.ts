import { Conta } from './conta';

export class Transacao {
  idTransacao!: number;
  conta!: Conta;
  valor: number = 0;
  data?: Date;
}
