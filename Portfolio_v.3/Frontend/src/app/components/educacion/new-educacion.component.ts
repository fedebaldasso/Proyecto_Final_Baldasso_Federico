import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Educación } from 'src/app/model/educación';
import { EducaciónService } from 'src/app/service/educación.service';

@Component({
  selector: 'app-new-educacion',
  templateUrl: './new-educacion.component.html',
  styleUrls: ['./new-educacion.component.css']
})
export class NewEducacionComponent implements OnInit {

  nombreE: string;
  descripcionE: string;

  constructor(private educaciónS: EducaciónService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const educacion = new Educación(this.nombreE, this.descripcionE);
    this.educaciónS.save(educacion).subscribe(
      data =>{
        alert("Educación añadida correctamente");
        this.router.navigate(['']);
      }, err =>{
        alert("Falló");
        this.router.navigate(['']);
      }
    )
  }

}
