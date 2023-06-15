import { Injectable } from '@angular/core';
import {
  HttpEvent,
  HttpInterceptor,
  HttpHandler,
  HttpRequest,
  HTTP_INTERCEPTORS,
  HttpClient, HttpResponse, HttpHeaders
} from '@angular/common/http';
import {catchError, Observable, throwError} from 'rxjs';

import { StorageService } from '../_services/storage.service';
import { EventBusService } from '../_shared/event-bus.service';
import { EventData } from '../_shared/event.class';
import {ACCESS_TOKEN} from "../constants/app.constants";
import {CookieService} from "ngx-cookie-service";

@Injectable()
export class HttpRequestInterceptor implements HttpInterceptor {
  private isRefreshing = false;

  constructor(
    private storageService: StorageService,
    private eventBusService: EventBusService,
    private cookieService: CookieService
  ) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    //const tok = localStorage.getItem(ACCESS_TOKEN);
    //const token = this.storageService.getUser().token;
    const token = this.cookieService.get(ACCESS_TOKEN)
    if (token) {
      req = req.clone({
        headers: req.headers.set(`Authorization`, `Bearer ${token}`)
      });
    }

    return next.handle(req);

    //   req = req.clone({
    //     withCredentials: true,
    //     headers: req.headers.set('Authorization', "Bearer " + this.storageService.getUser().token)
    //
    //   });
    //
    //   return next.handle(req).pipe(
    //     catchError((error) => {
    //       if (
    //         error instanceof HttpErrorResponse &&
    //         !req.url.includes('auth/signin') &&
    //         error.status === 401
    //       ) {
    //         return this.handle401Error(req, next);
    //       }
    //
    //       return throwError(() => error);
    //     })
    //   );
  }

  // constructor(private http: HttpClient) {}
  //
  // intercept(options: any): Observable<any> {
  //   const headers = new HttpHeaders({
  //     'Content-Type': 'application/json',
  //   });
  //
  //   if (localStorage.getItem(ACCESS_TOKEN)) {
  //     headers.append(
  //       'Authorization',
  //       'Bearer ' + localStorage.getItem(ACCESS_TOKEN)
  //     );
  //   }
  //
  //   const defaults = { headers };
  //   options = { ...defaults, ...options };
  //
  //   return this.http
  //     .request(options.method, options.url, options)
  //     .pipe(
  //       catchError((error: HttpResponse<any>) => {
  //         return throwError(error);
  //       })
  //     );
  // }



  // private handle401Error(request: HttpRequest<any>, next: HttpHandler) {
  //   if (!this.isRefreshing) {
  //     this.isRefreshing = true;
  //
  //     if (this.storageService.isLoggedIn()) {
  //       this.eventBusService.emit(new EventData('logout', null));
  //     }
  //   }
  //
  //   return next.handle(request);
  // }
}

export const httpInterceptorProviders = [
  { provide: HTTP_INTERCEPTORS, useClass: HttpRequestInterceptor, multi: true },
];
