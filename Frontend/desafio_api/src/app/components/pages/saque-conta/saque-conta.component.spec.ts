import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SaqueContaComponent } from './saque-conta.component';

describe('SaqueContaComponent', () => {
  let component: SaqueContaComponent;
  let fixture: ComponentFixture<SaqueContaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SaqueContaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SaqueContaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
