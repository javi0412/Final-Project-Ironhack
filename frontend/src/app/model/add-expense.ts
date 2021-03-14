export class AddExpense {

    constructor(
        private _amount: number, 
        private _description: string, 
        private _paidById: number,
        private _partyId: number
    ){}

    public get partyId(): number {
        return this._partyId;
    }
    public set partyId(value: number) {
        this._partyId = value;
    }
    public get paidById(): number {
        return this._paidById;
    }
    public set paidById(value: number) {
        this._paidById = value;
    }
    public get description(): string {
        return this._description;
    }
    public set description(value: string) {
        this._description = value;
    }
    public get amount(): number {
        return this._amount;
    }
    public set amount(value: number) {
        this._amount = value;
    }

}
