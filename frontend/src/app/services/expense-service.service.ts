import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AddExpense } from '../model/add-expense';
import { Observable } from 'rxjs';
import { IExpense } from './interfaces/user.interface';


@Injectable({
  providedIn: 'root'
})
export class ExpenseServiceService {

  constructor(
    private http: HttpClient
  ) { }

  storeExpense(addExpense:AddExpense):Observable<IExpense>{
    return this.http.post<IExpense>('http://localhost:8083/expense', this.expenseBody(addExpense));
  }

  expenseBody(addExpense:AddExpense):any{
    let expenseBody:any={
      amount:addExpense.amount,
      description:addExpense.description,
      paidById:addExpense.paidById,
      partyId:addExpense.partyId
    }
    return expenseBody;
  }
}
