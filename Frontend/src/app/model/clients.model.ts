export interface Client {
    id : string,
    code : string,
    firstName :string,
    lastName : string,
    programID :string,
    photo : string
}

export interface Payment {
    id: number,
    date : string,
    amount : number,
    type : string,
    status :string,
    file :string ,
    client : Client
}

export enum PaymentType{
    CASH,CHECK,TRANSFER,DEPOSIT
}

export enum PaymentStatus {
    CREATED,VALIDATED,REJECTED
}