import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Todo } from '../model/todo';

@Injectable({
  providedIn: 'root'
})
export class TodoServiceService {

  constructor(
    private http: HttpClient

  ) { }

  storeTodo(todo:Todo):Observable<Todo>{
    return this.http.post<Todo>('http://localhost:8083/todo/', this.todoBody(todo))
  }

  getAllTodos():Observable<TodoDB[]>{
    return this.http.get<TodoDB[]>('http://localhost:8083/todos');
  }

  getTodoById(id:number):Observable<TodoDB>{
    return this.http.get<TodoDB>('http://localhost:8083/todo/' + id);
  }

  deleteTodo(id:number):void{
    this.http.delete('http://localhost:8083/todo/' + id).subscribe(dataResult =>{
      console.log("To do with id "+ id+" deleted")
    })
  }

  todoBody(todo:Todo):any{
    let todoBody:any={
      "description":todo.description,
      "dueDate":todo.dueDate
    }
    return todoBody;
  }

}



export interface TodoDB{
  "description":string, 
  "creationDate": Date,
  "dueDate": Date,
  "done": boolean
}
