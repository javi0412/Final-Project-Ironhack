export interface IUser{
    id:number, 
    name:string, 
    email:string, 
    phone:string, 
    balanceSheet:[ 
        {
            [key:string]:number
        }
    ],

}

export interface IGroup{
    id:number,
    name:string, 
    userList:[
        {
            id:number, 
            name:string, 
            email:string, 
            phone:string, 
            balanceSheet:[ 
                {
                    [key:string]:number
                }
            ]
        }
    ]

}


export interface IExpense{
    id:number, 
    amount: number, 
    description:string, 
    paidBy:{
        id:number,
        name:string
    },
    partyId:number,
    creationDate:Date 

}