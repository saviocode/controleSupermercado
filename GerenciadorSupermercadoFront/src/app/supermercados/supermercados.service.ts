import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { SupermecadoModel } from '../models/supermercado.model';
import { API_SUPERMERCADO } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SupermecadoService {

  constructor(public http: HttpClient) { }

  listarSupermecado(page:number, perPage: number): Observable<any[]> {
    return this.http.get<SupermecadoModel[]>(`${API_SUPERMERCADO}?page=${page}&results=${perPage}`);
  }

  buscarPorNome(name: string): Observable<any> {
    return this.http.get<SupermecadoModel>(`${API_SUPERMERCADO}?nome=${name}`);
  }
}
