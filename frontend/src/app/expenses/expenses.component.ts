import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AddExpense } from '../model/add-expense';
import { Expense } from '../model/expense';
import { Group } from '../model/group';
import { User } from '../model/user';
import { ExpenseServiceService } from '../services/expense-service.service';
import { GroupServiceService } from '../services/group-service.service';
import { UserServiceService } from '../services/user-service.service';
import { CustomValidator } from '../Utils/custom-validator';

@Component({
  selector: 'app-expenses',
  templateUrl: './expenses.component.html',
  styleUrls: ['./expenses.component.css']
})
export class ExpensesComponent implements OnInit {
  form:FormGroup;

  descriptionField:FormControl;
  amountField:FormControl;
  paidByField:FormControl;
  partyIdField:FormControl;

  description:string;
  amount!:number;
  paidBy:User;
  paidById:number
  party:Group;
  partyId:number;
  selectedParty:Group;


  partyList:Group[] = [];
  selectedPartyUserList:User[];

  userList:User[] = [];

  expenseList: Expense[] = [];
  expenseUser:User;

  constructor(
    private userService: UserServiceService,
    private groupService: GroupServiceService, 
    private expenseService:ExpenseServiceService
    ) {
      this.descriptionField = new FormControl('',[Validators.required])
      this.amountField = new FormControl('',[Validators.required, CustomValidator.amountValidator])
      this.paidByField = new FormControl('', [Validators.required])
      this.partyIdField = new FormControl('', Validators.required),

      this.form = new FormGroup({
        expenseDescription:this.descriptionField,
        expenseAmount:this.amountField,
        expensePaidBy:this.paidByField,
        expensePartyId:this.partyIdField
      })
     }

  ngOnInit(): void {
    this.addGroupsFromDB()
    console.log(this.partyList)

  }

  addGroupsFromDB():void{
    this.groupService.getAllGroups().subscribe(data =>{
      for(let i=0;i< data.length;i++){
        this.userList = [];
        for(let j=0;j<data[i].userList.length;j++){
           let user:User = new User(data[i].userList[j].id, data[i].userList[j].name, data[i].userList[j].email, data[i].userList[j].phone);
            this.userList.push(user);
        }
        let group:Group = new Group(data[i].id, data[i].name, this.userList, []);
        this.partyList.push(group);
      }

    })
  }

  onPartyChange(e) {
    console.log(e);
    this.selectedPartyUserList = this.partyList[e.value-1].userList;
  }

  addExpense():void {
    let newExpense:AddExpense = new AddExpense(this.amount, this.description, this.paidById, this.partyId);
        
    this.expenseService.storeExpense(newExpense).subscribe(dataResult=>{
      this.userService.getUserById(Number(this.paidById)).subscribe(data=>{
        this.expenseUser = new User(data.id, data.name, data.email, data.phone);
      })
      let expense:Expense = new Expense(dataResult.id, dataResult.amount, dataResult.description, this.expenseUser, this.partyId, dataResult.creationDate)
      this.expenseList.push(expense);
    })
  }

}
