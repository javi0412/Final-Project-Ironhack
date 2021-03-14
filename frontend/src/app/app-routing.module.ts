import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CalendarComponent } from './calendar/calendar.component';
import { UserComponent } from './user/user.component';
import { Expense } from './model/expense';
import { ExpensesComponent } from './expenses/expenses.component';
import { GroupComponent } from './group/group.component';
import { ToDoComponent } from './todo/to-do.component';
import { BalanceComponent } from './balance/balance.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'todo', component: ToDoComponent },
  { path: 'calendar', component: CalendarComponent },
  { path: 'user', component: UserComponent },
  { path: 'group', component: GroupComponent },
  { path: 'expenses', component: ExpensesComponent },
  { path: 'balance', component: BalanceComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
