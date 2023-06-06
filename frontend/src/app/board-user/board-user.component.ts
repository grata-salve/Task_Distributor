import { Component, OnInit } from '@angular/core';
import {StorageService} from "../_services/storage.service";
import {User} from "../models/User";

@Component({
  selector: 'app-board-user',
  templateUrl: './board-user.component.html',
  styleUrls: ['./board-user.component.css']
})
export class BoardUserComponent implements OnInit {

  content?: User

  constructor(private storageService: StorageService) { }

  ngOnInit(): void {
    //this.content = User.getInstance().email

    this.content = this.storageService.getUser()


  }

}
