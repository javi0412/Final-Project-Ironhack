import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IUser } from './interfaces/user.interface';
import { User } from '../model/user';


@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(
    private http: HttpClient
  ) { }

  getAllUsers():Observable<UserDB[]>{
    return this.http.get<UserDB[]>('http://localhost:8083/users/');
  }

  getUserById(userId:number):Observable<IUser>{
    return this.http.get<IUser>('http://localhost:8083/user/' + userId);
  }

  storeUser(user:User): Observable<User>{
    return this.http.post<User>('http://localhost:8083/user/', this.userBody(user));
  }

  deleteUser(userId:number):void{
    console.log(userId);
    this.http.delete('http://localhost:8083/user/' + userId).subscribe(data=>
    console.log('Delete user with id = ' + userId));
  }

  userBody(user:User):any{
    let userBody: any = {
      "name":user.name,
      "email":user.email,
      "phone":user.phone
    }
    return userBody;

  }


}

export interface UserDB {
  "id": number,
  "name": string,
  "email":string, 
  "phone":string
}
