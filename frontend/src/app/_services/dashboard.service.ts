import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

const API_URL = `${environment.apiBaseUrl}/dashboard`;

@Injectable({
  providedIn: 'root'
})
export class DashboardService {
  constructor(private http: HttpClient) {
  }

  getUserTasksList(userId: number): Observable<any> {
    return this.http.get<any>(`${API_URL}/userTasks/${userId}`);
  }
}
