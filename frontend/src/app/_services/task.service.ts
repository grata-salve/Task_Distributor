import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Task} from "../models/Task";
import {UserTask} from "../models/UserTask";

const API_URL = `${environment.apiBaseUrl}/task`

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private httpClient: HttpClient) {
  }

  createTask(task: Task): Observable<any> {
    return this.httpClient.post(
      `${API_URL}/create`,
      {
        task
      }
    )
  }

  getTask(taskId: number): Observable<any> {
    return this.httpClient.get(`${API_URL}/get/'${taskId}`)
  }

  updateTask(task: Task): Observable<any> {
    return this.httpClient.put(
      `${API_URL}/update`,
      {
        task
      }
    )
  }

  deleteTask(taskId: number): Observable<any> {
    return this.httpClient.delete(`${API_URL}/delete/${taskId}`)
  }

  assignMember(userTask: UserTask): Observable<any> {
    return this.httpClient.post(
      `${API_URL}/assignMember`,
      {
        userTask
      }
    )
  }
}
