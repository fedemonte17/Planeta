import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Star } from '../model/star';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StarService  {

  constructor(private http:HttpClient) { }

getAll():Observable<Star[]>{
 return this.http.get<Star[]>('http://localhost:8084/api/v1/star/');
}

getOne(id:number):Observable<Star>{
  return this.http.get<Star>('http://localhost:8084/api/v1/star/' +id);
}

post(star:Star):Observable<Star>{

 return this.http.post<Star>('http://localhost:8084/api/v1/star/',star);
}

put(id:number, star:Star):Observable<Star>{

 return this.http.put<Star>('http://localhost:8084/api/v1/star/' +id,star);
}

delete(id:number){
 return this.http.delete('http://localhost:8084/api/v1/star/' +id);
}




}
