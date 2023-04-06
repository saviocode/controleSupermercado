import { TestBed } from '@angular/core/testing';

import { SupermecadoService } from './supermercados.service';

describe('SupermecadoService', () => {
  let service: SupermecadoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SupermecadoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
