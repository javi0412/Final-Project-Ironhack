import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Todo } from '../model/todo';
import { TodoServiceService } from '../services/todo-service.service';

@Component({
  selector: 'app-to-do',
  templateUrl: './to-do.component.html',
  styleUrls: ['./to-do.component.css']
})
export class ToDoComponent implements OnInit {

  form:FormGroup;

  descriptionField:FormControl;
  dueDateField:FormControl;

  description:string = "";
  dueDate:Date;


  todoList: Todo[] =[];

  constructor(
    private todoService:TodoServiceService
  ) {
    this.descriptionField = new FormControl('',[Validators.required])
    this.dueDateField = new FormControl('')
    this.form = new FormGroup({
      description:this.descriptionField,
      dueDate:this.dueDateField
    })
   }

  ngOnInit(): void {
  }


  addNewTask():void{
    let newTodo:Todo = new Todo(1,this.description, this.dueDate);
    this.todoService.storeTodo(newTodo).subscribe(dataResult =>{
      newTodo.id = dataResult.id;
      newTodo.creationDate = dataResult.creationDate;
      newTodo.isDone=dataResult.isDone;
      newTodo.dueDate = dataResult.dueDate;
    })

    this.todoList.push(newTodo);
  }
  
  onEventAddNewElement(event:KeyboardEvent): void {
    if(event.key === 'Enter') {
      this.addNewTask();
    }
  }

  removeTasks():void{
    this.todoList = [];
  }

  removeDoneTasks():void{
      this.todoList= this.todoList.filter(item=> !item.isDone) 
  }
 

  markAsDone(task:Todo):void{
    if(task.isDone==false){
      task.isDone = true;
    } else{
      task.isDone = false;
    }
  }


  }

 


