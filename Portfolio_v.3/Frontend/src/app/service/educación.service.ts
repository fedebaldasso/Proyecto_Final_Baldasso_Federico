import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Educación } from '../model/educación';

@Injectable({
  providedIn: 'root'
})
export class EducaciónService {
  URL = 'http://localhost:8080/educación/';

  constructor(private httpClient : HttpClient) { }

  public lista(): Observable<Educación[]>{
    return this.httpClient.get<Educación[]>(this.URL + 'lista');
  }

  public detail(id: number): Observable<Educación>{
    return this.httpClient.get<Educación>(this.URL + `detail/${id}`);
  }

  public save(educación: Educación): Observable<any>{
    return this.httpClient.post<any>(this.URL + 'create', educación);
  }

  public update(id: number, educación: Educación): Observable<any>{
    return this.httpClient.put<any>(this.URL + `update/${id}`, educación);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.URL + `delete/${id}`);
  }

}
