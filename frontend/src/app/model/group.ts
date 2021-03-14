import { Expense } from "./expense";
import { User } from "./user";

export class Group {

    constructor(
        private _id: number, 
        private _name: string, 
        private _userList: User[]    ){}

    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
   
    public get name(): string {
        return this._name;
    }
    public set name(value: string) {
        this._name = value;
    }

    public get userList(): User[] {
        return this._userList;
    }
    public set userList(value: User[]) {
        this._userList = value;
    }

}
