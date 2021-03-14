import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { User } from '../model/user';
import { UserServiceService } from '../services/user-service.service';
import { CustomValidator } from '../Utils/custom-validator';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  
  form:FormGroup;

  nameField:FormControl;
  emailField:FormControl;
  phoneField:FormControl;

  userName:string = "";
  userEmail:string = "";
  userPhone:string = "";

  userList:User[] = [];

  id:number;
  name:string = '';
  email:string = '';
  phone:string = '';


  constructor(
    private userService:UserServiceService

  ) {

    this.nameField = new FormControl('',[Validators.required, CustomValidator.nameValidator]);
    this.emailField = new FormControl('',[Validators.required, Validators.email]);
    this.phoneField = new FormControl('',[Validators.required]);

    this.form = new FormGroup({
      name:this.nameField,
      email:this.emailField,
      phone:this.phoneField
    }
    )
  
  }

  addUser():void{
    let newUser:User = new User(1, this.userName, this.userEmail, this.userPhone);
    this.userService.storeUser(newUser).subscribe(dataResult =>
      {
        console.log('User ' + newUser.name + ' created');
        newUser.id = dataResult.id;
        this.userList.push(newUser);
      });
  }

  deleteUser(index:number, id:string):void{
    this.userService.deleteUser(Number(id));
    this.userList.splice(index, 1);
  }

  ngOnInit(): void {
    this.addUsersFromDB();
  }

  addUsersFromDB(): void {
    this.userService.getAllUsers().subscribe(dataResult => {
      if (this.userList.length < dataResult.length){
        this.userList =[];
        for(let i=0; i<dataResult.length;i++){ 
          this.id = dataResult[i].id;
          this.name = dataResult[i].name;
          this.email = dataResult[i].email;
          this.phone = dataResult[i].phone;
          this.userList.push(
            new User(this.id, this.name, this.email, this.phone));
      }}
      this.id =  null;
      this.name =  '';
      this.email = '';
      this.phone = '';    })
  } 





}
