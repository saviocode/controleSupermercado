import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SupermecadosFormComponent } from './super-form.component';

describe('SupermecadosFormComponent', () => {
  let component: SupermecadosFormComponent;
  let fixture: ComponentFixture<SupermecadosFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SupermecadosFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SupermecadosFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
