import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

const API_URL = `${environment.apiBaseUrl}/logs`

@Injectable({
  providedIn: 'root'
})
export class ActionLogService {

  constructor(private httpClient: HttpClient) {
  }

  getActionLog(logId: number): Observable<any> {
    return this.httpClient.get(`${API_URL}/get/${logId}`)
  }

  getActionLogsByUser(userId: number): Observable<any> {
    return this.httpClient.get(`${API_URL}/getUserLogs/${userId}`)
  }

  getActionLogsByTask(taskId: number): Observable<any> {
    return this.httpClient.get(`${API_URL}/getTaskLogs/${taskId}`)
  }
}
