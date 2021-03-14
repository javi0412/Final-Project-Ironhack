import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AddGroup } from '../model/add-group';
import { Group } from '../model/group';
import { User } from '../model/user';
import { GroupServiceService } from '../services/group-service.service';
import { UserServiceService } from '../services/user-service.service';
import { CustomValidator } from '../Utils/custom-validator';

@Component({
  selector: 'app-group',
  templateUrl: './group.component.html',
  styleUrls: ['./group.component.css']
})
export class GroupComponent implements OnInit {
  form:FormGroup;

  nameField:FormControl;
  usersField:FormControl;

  partyList:Group[] = [];

  groupId:number;
  groupName:string = '';
  groupUsersId:number[] = [];
  groupUsersName:string[] = [];

  userList:User[] = [];
  userList2:User[] = [];

  userNameList:string[];

  userId:number;
  userName:string = '';
  userEmail:string = '';
  userPhone:string = '';

  constructor(
    private userService: UserServiceService, 
    private groupService: GroupServiceService
  ) {
    this.nameField = new FormControl('',[Validators.required, CustomValidator.nameValidator]);
    this.usersField = new FormControl('',[Validators.required])
    this.form = new FormGroup({
      groupName:this.nameField,
      groupUsers:this.usersField
    })
   }

  ngOnInit(): void {
    this.addUsersFromDB();
    this.addGroupsFromDB();
    console.log(this.partyList)

  }

  addGroupsFromDB():void{
    this.groupService.getAllGroups().subscribe(data =>{
      for(let i=0;i< data.length;i++){
        this.userList2 = [];
        for(let j=0;j<data[i].userList.length;j++){
           let user:User = new User(data[i].userList[j].id, data[i].userList[j].name, data[i].userList[j].email, data[i].userList[j].phone);
            this.userList2.push(user);
        }
        let group:Group = new Group(data[i].id, data[i].name, this.userList2);
        this.partyList.push(group);
      }

    })
  }

  addUsersFromDB(): void {
    this.userService.getAllUsers().subscribe(dataResult => {
      if (this.userList.length < dataResult.length){
        this.userList =[];
        this.userNameList = [];
        for(let i=0; i<dataResult.length;i++){ 
          this.userId = dataResult[i].id;
          this.userName = dataResult[i].name;
          this.userEmail = dataResult[i].email;
          this.userPhone = dataResult[i].phone;
          this.userList.push(
            new User(this.userId, this.userName, this.userEmail, this.userPhone));
          this.userNameList.push(this.userName);
      }}
      this.userId =  null;
      this.userName =  '';
      this.userEmail = '';
      this.userPhone = '';    })
  } 

  addGroup():void{
    let newGroup = new AddGroup (this.groupName, this.groupUsersId);
    this.groupService.storeGroup(newGroup).subscribe(dataResult=>{
      this.groupId = dataResult.id;
    })
    for(let i=0; i<this.groupUsersId.length;i++){
      this.userService.getUserById(this.groupUsersId[i]).subscribe(data=>{
        this.groupUsersName.push(data.name);
      })
    }
  }

}
