import { Component, OnInit } from '@angular/core';
import { StarService } from 'src/app/servicios/star.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Star } from 'src/app/model/star';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-listado-star',
  templateUrl: './listado-star.component.html',
  styleUrls: ['./listado-star.component.css']
})
export class ListadoStarComponent implements OnInit {

  star: Star ={
    id:0,
    nombre:"",
    densidad:""

  }

  todoForm: FormGroup;
  submitted = false;
  registerForm: FormGroup;
  form: any;

  constructor(private sServicio:StarService, private act:ActivatedRoute, private rou:Router, private formBuilder: FormBuilder  ) { 

    this.act.params.subscribe((data) =>{
      if(data.id !=0){
        this.sServicio.getOne(data.id).subscribe((data2) =>{this.star = data2})

      }
    });

  }



  ngOnInit() {
    this.registerForm = this.formBuilder.group({
     
      nombre: ['', Validators.required],
      densidad: ['', Validators.required],
     
  });

  }

  get f() { return this.registerForm.controls; }


  onSubmit() {
    this.submitted = true;
    if (this.registerForm.invalid) {
      return;
  }

    if(this.star.id != 0){
    this.sServicio.put(this.star.id, this.star).subscribe((data)=>{
      location.reload();
    });
  }
  else{
    this.sServicio.post(this.star).subscribe((data)=>{
      this.rou.navigate(['/star/'+data.id]);
    });
  }

   

    
    alert('GUARDADO CON EXITO\n\n' + JSON.stringify(this.registerForm.value, null, 4));
}

  onReset() {
    this.submitted = false;
    this.registerForm.reset();
}

}
