export class Todo {

    private _creationDate: Date;
    private _isDone: boolean;


    constructor(
        private _id: number, 
        private _description: string, 
        private _dueDate?: Date
    ){}
    
    public get isDone(): boolean {
        return this._isDone;
    }
    public set isDone(value: boolean) {
        this._isDone = value;
    }
    public get dueDate(): Date {
        return this._dueDate;
    }
    public set dueDate(value: Date) {
        this._dueDate = value;
    }
    public get description(): string {
        return this._description;
    }
    public set description(value: string) {
        this._description = value;
    }
    public get creationDate(): Date {
        return this._creationDate;
    }
    public set creationDate(value: Date) {
        this._creationDate = value;
    }
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }

}
