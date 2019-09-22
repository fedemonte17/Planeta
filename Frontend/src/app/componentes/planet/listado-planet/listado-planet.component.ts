import { Component, OnInit } from '@angular/core';
import { Planet } from 'src/app/model/planet';
import { PlanetService } from 'src/app/servicios/planet.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Star } from 'src/app/model/star';
import { StarService } from 'src/app/servicios/star.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';



@Component({
  selector: 'app-listado-planet',
  templateUrl: './listado-planet.component.html',
  styleUrls: ['./listado-planet.component.css']
})
export class ListadoPlanetComponent implements OnInit {

  stars: Star [] = []

  nuevaStar: boolean = false;
  starPost: Star = {
    id: null,
    nombre: null,
    densidad: null

  };

  planet: Planet = {
    id: undefined,
    nombre: "",
    size: "",
    star: {
      id: 0 ,
      nombre:"",
      densidad: "",
    }

  };

  todoForm: FormGroup;
  submitted = false;
  registerForm: FormGroup;
  form: any;

  constructor(private pServicio: PlanetService, private act: ActivatedRoute,
              private cservicios: StarService, private rou: Router, private formBuilder: FormBuilder ) {

              this.getStar();

              this.act.params.subscribe((data) => {
                     if (data.id != 0){
              this.pServicio.getOne(data.id).subscribe((data2) => {this.planet = data2; })

      }
    });


  }

  ngOnInit() {

 

    this.registerForm = this.formBuilder.group({
      star: ['', Validators.required],
      nombre: ['', Validators.required],
      size: ['', Validators.required],
     
  });


  }

  get f() { return this.registerForm.controls; }

  onSubmit() {
      this.submitted = true;
      if (this.registerForm.invalid) {
        return;
    }

      if (this.planet.id != null) {
        this.planet.star.id =  this.planet.star.id;
        this.pServicio.put(this.planet.id, this.planet).subscribe((data) => {
        this.rou.navigate(['/planet']);
        });
      } else {
  
        this.planet.star.id =  this.planet.star.id;
        this.pServicio.post(this.planet).subscribe((data) => {
        this.rou.navigate(['/planet']);
          });
      }

     

      
      alert('GUARDADO CON EXITO\n\n' + JSON.stringify(this.registerForm.value, null, 4));
  }

  onReset() {
      this.submitted = false;
      this.registerForm.reset();
  }


  getStar() {
    this.cservicios.getAll().subscribe((data) => this.stars = data);

  }



  async  guardarStar(){

    this.nuevaStar = false;

    await this.cservicios.post(this.starPost).subscribe((data) => {
      this.planet.star.id = data.id
      this.getStar();
    })

  }

}