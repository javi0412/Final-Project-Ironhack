import { User } from "./user";

export class Expense {
    constructor(
        private _id: number, 
        private _amount: number, 
        private _description: string, 
        private _paidBy: User,
        private _partyId: number, 
        private _creationDate: Date
    ){}

    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }

    public get amount(): number {
        return this._amount;
    }
    public set amount(value: number) {
        this._amount = value;
    }

    public get description(): string {
        return this._description;
    }
    public set description(value: string) {
        this._description = value;
    }

    public get paidBy(): User {
        return this._paidBy;
    }
    public set paidBy(value: User) {
        this._paidBy = value;
    }

    public get partyId(): number {
        return this._partyId;
    }
    public set partyId(value: number) {
        this._partyId = value;
    }

    public get creationDate(): Date {
        return this._creationDate;
    }
    public set creationDate(value: Date) {
        this._creationDate = value;
    }

}
