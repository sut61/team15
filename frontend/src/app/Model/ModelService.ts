export class CustomerDent{
    public ID:string;
    public FullName:string;
}

export class DentFull{
    public ID:string;
    public FullName:string;
}

export class nametype{
    public typeId:String;
    public nameType:String;
}

export class Appointment{
    public namecus:String;
    public namedent:String;
    public typename:String;
    public date:Date;
}
export class namegroup{
    public ID:String;
    public nameGroup:String;
}

export class ReferringForm{
    public namecus:String;
    public namedent:String;
    public typename:String;
    public date:Date;
    public group:String;
    public tel:String;
}