import { Component, OnInit } from '@angular/core';
import { Educación } from 'src/app/model/educación';
import { EducaciónService } from 'src/app/service/educación.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent implements OnInit {
  edu: Educación[] = [];

  constructor(private educaciónS: EducaciónService, private tokenService: TokenService) { }
  isLogged = false;
  
  ngOnInit(): void {
    this.cargarEducación();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarEducación(): void{
    this.educaciónS.lista().subscribe(
      data =>{
        this.edu = data;
      }
    )
  }

  delete(id?: number){
    if( id != undefined){
      this.educaciónS.delete(id).subscribe(
        data => {
          this.cargarEducación();
        }, err => {
          alert("No se pudo eliminar");
        }
      )
    }
  }

}
