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

// {
//     "id": 1,
//     "amount": 125.36,
//     "description": "Visas",
//     "paidBy": {
//         "id": 1,
//         "name": "Victor",
//         "email": "javiicc94@gmail.com",
//         "phone": "677518326",
//         "balanceSheet": {
//             "Javi": 62.68
//         }
//     },
//     "partyId": 1,
//     "creationDate": "2021-03-14T16:05:31.108+00:00"
// }

export interface IExpense{
    id:number, 
    amount: number, 
    description:string, 
    paidBy:{
        name:string
    },
    creationDate:Date 

}