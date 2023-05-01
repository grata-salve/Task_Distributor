import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

const API_URL = 'http://localhost:8080/dashboard/';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {
  constructor(private http: HttpClient) { }

  getUserTasksList(userId: number): Observable<any> {
    return this.http.get(API_URL + `userTasks/${userId}`,
      {headers: {'Content-Type': 'application/json'}, responseType: 'text'})
  }

}
