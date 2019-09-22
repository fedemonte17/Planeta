import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './componentes/home/home.component';
import { PlanetComponent } from './componentes/planet/planet.component';
import { StarComponent } from './componentes/star/star.component';
import { ListadoStarComponent } from './componentes/star/listado-star/listado-star.component';
import { ListadoPlanetComponent } from './componentes/planet/listado-planet/listado-planet.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'planet', component: PlanetComponent},
  {path: 'planet/:id', component: ListadoPlanetComponent},
  {path: 'star', component: StarComponent},
  {path: 'star/:id', component: ListadoStarComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
