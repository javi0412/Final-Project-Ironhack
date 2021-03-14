import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { User } from '../model/user';

@Component({
  selector: 'app-user-card',
  templateUrl: './user-card.component.html',
  styleUrls: ['./user-card.component.css']
})
export class UserCardComponent implements OnInit {

  @Input() user!:User;

  @Output() deleteUserEvent = new EventEmitter();


  constructor() { }

  ngOnInit(): void {
  }

  deleteUser(id:number):void{
    this.deleteUserEvent.emit(String(id));
  }

}
