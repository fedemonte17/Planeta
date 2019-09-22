import { Component, OnInit } from '@angular/core';
import { PlanetService } from 'src/app/servicios/planet.service';
import { Planet } from 'src/app/model/planet';
import { Router } from '@angular/router';


@Component({
  selector: 'app-planet',
  templateUrl: './planet.component.html',
  styleUrls: ['./planet.component.css']
})
export class PlanetComponent implements OnInit {

planets: Planet[] = [];

  constructor(private pservicio: PlanetService, private rou: Router) {
    this.pservicio.getAll().subscribe((data) => {  this.planets = data,  console.log(this.planets); });

   }

  ngOnInit() {

  }



delete(id: number) {
  this.pservicio.delete(id).subscribe((data) => {
  window.location.reload();
  });
}

update(id: number) {
  this.rou.navigate(['planet/' + id]);
}

}
