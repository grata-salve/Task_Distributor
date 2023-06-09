import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';
import { StorageService } from '../_services/storage.service';
import {UserService} from "../_services/user.service";
import {GOOGLE_AUTH_URL} from "../constants/app.constants";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: any = {
    email: null,
    password: null
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  userDetails: string = '';
  googleUrl = GOOGLE_AUTH_URL

  constructor(private authService: AuthService, private storageService: StorageService,
              private userService: UserService) { }

  ngOnInit(): void {
    if (this.storageService.isLoggedIn()) {
      this.isLoggedIn = true;
      this.roles = this.storageService.getJwt().roles;
      this.loadUser()
    }
  }

  public loadUser() {
    this.userService.getUser().subscribe({
        next: data => {
          this.storageService.saveUser(data);
        },
        error: err => {
          this.errorMessage = err.error.message;
        }
      }
    );
  }

  onSubmit(): void {
    const { email, password } = this.form;
    this.authService.login(email, password).subscribe({
      next: data => {
        this.storageService.saveJwt(data);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.storageService.getJwt().roles;
        this.reloadPage();
      },
      error: err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    });
  }

  reloadPage(): void {
    window.location.reload();
  }
}
