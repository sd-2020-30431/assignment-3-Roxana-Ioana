import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GoalService {

  private baseUrl = 'http://localhost:8080/goal';
  
  constructor(private http: HttpClient) { }

  createGoal(goal:Object):Observable<Object>{
    return this.http.post(`${this.baseUrl}`, goal);
  }

  getGoal(idUser:number):Observable<any>{
    return this.http.get(`${this.baseUrl}/${idUser}`);
  }

  getDailyCalories(idUser:number):Observable<any>{
    return this.http.get(`${this.baseUrl}/dailyCalories/${idUser}`);
  }
}
