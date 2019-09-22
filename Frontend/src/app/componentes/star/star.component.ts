import { Component, OnInit } from '@angular/core';
import { Star } from 'src/app/model/star';
import { StarService } from 'src/app/servicios/star.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-star',
  templateUrl: './star.component.html',
  styleUrls: ['./star.component.css']
})
export class StarComponent implements OnInit {

  star: Star[] = [];

  constructor(private cservicios: StarService, private rou: Router) { }

  ngOnInit() {
    this.cservicios.getAll().subscribe((data) => {
      this.star = data;
      console.log(this.star);
    });
  }

  delete(id: number) {
    this.cservicios.delete(id).subscribe((data) => {
    window.location.reload();
    });
  }

  update(id: number) {
    this.rou.navigate(['star/' + id]);
  }

}
