import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {environment} from "../../environments/environment";

const AUTH_API = `${environment.apiBaseUrl}/api/v1/auth`;

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient) {}

  login(email: string, password: string): Observable<any> {
    return this.http.post(
      `${AUTH_API}/authenticate`,
      {
        email,
        password,
      },
      httpOptions
    );
  }

  register(firstname: string, lastname: string, email: string, password: string): Observable<any> {
    return this.http.post(
      `${AUTH_API}/register`,
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
    sessionStorage.removeItem("Authorization")
    return this.http.post(`${AUTH_API}/logout`, { }, httpOptions);
  }
}
