import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import {StorageService} from "../_services/storage.service";

@Component({
  selector: 'app-oauth2-redirect-handler',
  templateUrl: './oauth2-redirect-handler.component.html',
  styleUrls: ['./oauth2-redirect-handler.component.css']
})
export class OAuth2RedirectHandlerComponent implements OnInit {
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private cookieService: CookieService,
    private storageService: StorageService
  ) { }

  ngOnInit(): void {
    const accessToken = OAuth2RedirectHandlerComponent.getUrlParameter('token');
    const error = OAuth2RedirectHandlerComponent.getUrlParameter('error');

    if (accessToken) {
      this.storageService.saveJwtOauth(accessToken)
      this.router.navigate(['/login'], {state: {from: this.route.snapshot.url}});
    } else {
      this.router.navigate(['/login'], {state: {from: this.route.snapshot.url, error: error}});
    }
  }

  private static getUrlParameter(name: string): string {
    name = name.replace(/\[/, '\\[').replace(/]/, '\\[]');
    const regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
    const results = regex.exec(window.location.search);
    return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
  }
}
