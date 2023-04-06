import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BottonSheetConfirmaComponent } from './botton-sheet-confirma.component';

describe('BottonSheetConfirmaComponent', () => {
  let component: BottonSheetConfirmaComponent;
  let fixture: ComponentFixture<BottonSheetConfirmaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BottonSheetConfirmaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BottonSheetConfirmaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
