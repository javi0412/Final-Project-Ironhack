export class AddGroup {

    constructor(
        private _name: string,
        private _userIdList: number[]
    ){}
    
    public get userIdList(): number[] {
        return this._userIdList;
    }
    public set userIdList(value: number[]) {
        this._userIdList = value;
    }
    public get name(): string {
        return this._name;
    }
    public set name(value: string) {
        this._name = value;
    }

}
