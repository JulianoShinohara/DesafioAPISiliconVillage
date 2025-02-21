import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class MessageService {
  message: string = '';
  type: string = '';
  constructor() {}
  alert(mensagem: string) {
    this.type = 'alert';
    this.message = mensagem;

    setTimeout(() => {
      this.clear();
    }, 4000);
  }

  clear() {
    this.message = '';
  }

  confirm(message: string) {
    this.type = 'confirm';
    this.message = message;
    console.log('chegou no confirm');
    setTimeout(() => {
      this.clear();
    }, 10000);
  }

  tratadorDeErro(error: any, errorData: { campo: string, message: string }[] | string) {
    if (error.status === 401 &&  typeof errorData === 'string') {
      return this.alert(errorData);
    }
  
    if (error.status === 400 && Array.isArray(errorData)) {
      let message = errorData.map(entry => entry.message).join(' - ');
  
      this.alert(message);
    }
  }
  
  
  
}