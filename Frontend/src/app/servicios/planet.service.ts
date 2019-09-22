import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Planet } from '../model/planet';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlanetService {

  constructor(private http:HttpClient) { }

getAll():Observable<Planet[]>{
 return this.http.get<Planet[]>('http://localhost:8084/api/v1/planet/');
}

getOne(id:number):Observable<Planet>{
  return this.http.get<Planet>('http://localhost:8084/api/v1/planet/' +id);
}

post(planet:Planet):Observable<Planet>{

 return this.http.post<Planet>('http://localhost:8084/api/v1/planet/',planet);
}

put(id:number, planet:Planet):Observable<Planet>{

 return this.http.put<Planet>('http://localhost:8084/api/v1/planet/' +id,planet);
}

delete(id:number){
 return this.http.delete('http://localhost:8084/api/v1/planet/' +id);
}




}
