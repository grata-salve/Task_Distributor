import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Team} from "../models/Team";
import {UserTeam} from "../models/UserTeam";

const API_URL = `${environment.apiBaseUrl}/team`

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  constructor(private httpClient: HttpClient) {
  }

  createTeam(team: Team): Observable<any> {
    return this.httpClient.post(
      `${API_URL}/create`,
      {
        team
      }
    )
  }

  getTeam(teamId: number): Observable<any> {
    return this.httpClient.get(`${API_URL}/get/'${teamId}`)
  }

  updateTeam(team: Team): Observable<any> {
    return this.httpClient.put(
      `${API_URL}/update`,
      {
        team
      }
    )
  }

  deleteTeam(teamId: number): Observable<any> {
    return this.httpClient.delete(`${API_URL}/delete/${teamId}`)
  }

  addMember(userTeam: UserTeam): Observable<any> {
    return this.httpClient.post(
      `${API_URL}/addMember`,
      {
        userTeam
      }
    )
  }

  removeMember(userId: number): Observable<any> {
    return this.httpClient.delete(`${API_URL}/removeMember/${userId}`)
  }

}
