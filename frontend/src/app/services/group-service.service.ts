import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Group } from '../model/group';
import { AddGroup } from '../model/add-group';
import { Observable } from 'rxjs';
import { IGroup } from './interfaces/user.interface';


@Injectable({
  providedIn: 'root'
})
export class GroupServiceService {

  constructor(
    private http: HttpClient
  ) { }

  storeGroup(group:AddGroup):Observable<Group>{
    return this.http.post<Group>('http://localhost:8083/group/', this.groupBody(group));
  }

  getAllGroups():Observable<IGroup[]>{
    return this.http.get<IGroup[]>('http://localhost:8083/groups/');
  }

  getGroupById(groupId:number):Observable<IGroup>{
    return this.http.get<IGroup>('http://localhost:8083/group' + groupId);
  }

  deleteGroup(groupId:number):void{
    console.log(groupId);
    this.http.delete('http://localhost:8083/group' + groupId).subscribe(data=>
    console.log('Group' + groupId + ' deleted'));
  }

  groupBody(addGroup:AddGroup):any{
    let groupBody: any = {
      "name":addGroup.name,
      "userIdList":addGroup.userIdList
    }
    return groupBody;
  }


}
