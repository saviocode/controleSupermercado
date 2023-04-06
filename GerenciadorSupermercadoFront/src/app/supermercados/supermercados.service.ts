import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { SupermecadoModel } from '../model/supermercado.model';

@Injectable({
  providedIn: 'root'
})
export class SupermecadoService {
  url = `https://randomuser.me/api/`;

  constructor(public http: HttpClient) { }

  listarSupermecado(page:number, perPage: number): Observable<any[]> {
    return this.http.get<SupermecadoModel[]>(`${this.url}?page=${page}&results=${perPage}`);
  }

  buscarPorNome(name: string): Observable<any> {
    return this.http.get<SupermecadoModel>(`${this.url}?nome=${name}`);
  }
}
