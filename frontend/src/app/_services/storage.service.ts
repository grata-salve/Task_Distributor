import { Injectable } from '@angular/core';
import { CookieService } from "ngx-cookie-service";
import { ACCESS_TOKEN, COOKIE_EXPIRY_DAYS, USER } from "../constants/app.constants";

@Injectable({
  providedIn: 'root'
})
export class StorageService {
  constructor(private cookieService: CookieService) { }

  clean(): void {
    window.sessionStorage.clear();
  }

  public saveJwt(user: any): void {
    this.cookieService.set(ACCESS_TOKEN, user.accessToken, COOKIE_EXPIRY_DAYS)
  }

  public saveJwtOauth(accessToken: any): void {
    this.cookieService.set(ACCESS_TOKEN, accessToken, COOKIE_EXPIRY_DAYS,
      "/", "localhost")
  }

  public getJwt(): any {
    return this.cookieService.get(ACCESS_TOKEN)
  }

  public saveUser(userDetails: any): void {
    window.sessionStorage.setItem(USER, userDetails);
  }

  public getUser(): any {
    const userDetails = window.sessionStorage.getItem(USER);
    if (userDetails) {
      return JSON.parse(userDetails)
    }
    return {};
  }

  public isLoggedIn(): boolean {
    return !!this.cookieService.get(ACCESS_TOKEN);
  }

  public logout() {
    this.cookieService.delete(ACCESS_TOKEN)
    sessionStorage.removeItem(USER)
  }
}
