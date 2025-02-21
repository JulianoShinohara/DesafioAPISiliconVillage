import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransacoesContaPeriodoComponent } from './transacoes-conta-periodo.component';

describe('TransacoesContaPeriodoComponent', () => {
  let component: TransacoesContaPeriodoComponent;
  let fixture: ComponentFixture<TransacoesContaPeriodoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TransacoesContaPeriodoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TransacoesContaPeriodoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
