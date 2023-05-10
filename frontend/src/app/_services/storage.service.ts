import { Injectable } from '@angular/core';
import {User} from "../models/User";

const USER_KEY = 'Authorization';
const USER_DETAILS = 'User'

@Injectable({
  providedIn: 'root'
})
export class StorageService {
  constructor() {}

  clean(): void {
    window.sessionStorage.clear();
  }

  public saveUser(user: any): void {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }

  public getUser(): any {
    const user = window.sessionStorage.getItem(USER_KEY);
    if (user) {
      return JSON.parse(user);
    }
    return {};
  }

  public saveUserDetails(userDetails: any): void {
    window.sessionStorage.removeItem(USER_DETAILS);
    window.sessionStorage.setItem(USER_DETAILS, userDetails);
  }

  public getUserDetails(): any {
    const userDetails = window.sessionStorage.getItem(USER_DETAILS);
    if (userDetails) {
      return JSON.parse(userDetails)
    }
    return {};
  }

  public isLoggedIn(): boolean {
    const user = window.sessionStorage.getItem(USER_KEY);
    return !!user;
  }
}
