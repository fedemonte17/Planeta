import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import {RouterModule} from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './componentes/home/home.component';
import { PlanetComponent } from './componentes/planet/planet.component';
import { ListadoPlanetComponent } from './componentes/planet/listado-planet/listado-planet.component';
import { StarComponent } from './componentes/star/star.component';
import { ListadoStarComponent } from './componentes/star/listado-star/listado-star.component';
import { HttpClientModule } from '@angular/common/http';
import { NuevoComponent } from './componentes/nuevo/nuevo.component';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { SharedComponent } from './componentes/shared/shared.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PlanetComponent,
    StarComponent,
    NuevoComponent,
    ListadoPlanetComponent,
    ListadoStarComponent,
    SharedComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
 
})
export class AppModule { }
