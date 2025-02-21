import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransacoesContaComponent } from './transacoes-conta.component';

describe('TransacoesContaComponent', () => {
  let component: TransacoesContaComponent;
  let fixture: ComponentFixture<TransacoesContaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TransacoesContaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TransacoesContaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
