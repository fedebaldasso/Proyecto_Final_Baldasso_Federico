import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Experiencia } from '../model/experiencia';

@Injectable({
  providedIn: 'root'
})
export class SExperienciaService {
  // expURL = 'http://localhost:8080/explab/';
  expURL = 'https://back-my-portfolio.herokuapp.com/explab/';

  constructor(private htttpClient: HttpClient) { }

  public lista(): Observable<Experiencia[]>{
    return this.htttpClient.get<Experiencia[]>(this.expURL + 'lista');
  }

  public detail(id:number): Observable<Experiencia>{
    return this.htttpClient.get<Experiencia>(this.expURL + `detail/${id}`);
  }

  public save(experiencia: Experiencia): Observable<any>{
    return this.htttpClient.post<any>(this.expURL + 'create', experiencia);
  }

  public update(id: number, experiencia: Experiencia): Observable<any>{
    return this.htttpClient.put<any>(this.expURL + `update/${id}`, experiencia);
  }

  public delete(id: number): Observable<any>{
    return this.htttpClient.delete<any>(this.expURL + `delete/${id}`);
  }
}
