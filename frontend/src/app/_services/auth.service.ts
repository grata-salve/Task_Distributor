import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {API_BASE_URL} from "../constants/app.constants";
import {StorageService} from "./storage.service";

const AUTH_API = `${API_BASE_URL}/auth`;

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(
    private http: HttpClient,
    private storageService: StorageService
  ) { }

  login(email: string, password: string): Observable<any> {
    return this.http.post(
      `${AUTH_API}/login`,
      {
        email,
        password,
      },
      httpOptions
    );
  }

  register(firstname: string, lastname: string, email: string, password: string): Observable<any> {
    return this.http.post(
      `${AUTH_API}/signup`,
      {
        firstname,
        lastname,
        email,
        password,
      },
      httpOptions
    );
  }

  logout(): Observable<any> {
    return this.http.post(`${AUTH_API}/logout`, { }, httpOptions);
  }
}
