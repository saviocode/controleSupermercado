import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SupermercadoListaComponent } from './super-lista.component';

describe('SupermercadoListaComponent', () => {
  let component: SupermercadoListaComponent;
  let fixture: ComponentFixture<SupermercadoListaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SupermercadoListaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SupermercadoListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
