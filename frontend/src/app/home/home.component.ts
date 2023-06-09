import { Component, OnInit } from '@angular/core';
import {DashboardService} from "../_services/dashboard.service";
import {HttpErrorResponse} from "@angular/common/http";
import {Task} from "../models/Task";
import {StorageService} from "../_services/storage.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  content?: string;
  userTasks?: Task[]

  constructor(private dashboardService: DashboardService, private storageService: StorageService)
  { }

  ngOnInit(): void {
    if (this.storageService.isLoggedIn()) {
      this.loadUserTasksList(this.storageService.getUser().id)
    }
  }

  public loadUserTasksList(userId: number) {
    this.dashboardService.getUserTasks(userId).subscribe(
      (response: Task[]) => {
        this.userTasks = response
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    )
  }

}
