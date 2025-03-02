import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  //a temporary front authentification solution 
  public users:any = {
    admin : {password : '1234',roles: ['CLIENT','ADMIN']},
    user1 : {password:'1234',roles : ['CLIENT']}
  }
  public username :any;
  public isAuthentificated : boolean=false;
  public roles : string[]=[];
  constructor() { }
  public login(username:string, password : string):boolean {
    if (this.users[username]&& this.users[username]['password']==password) {
      this.username=username;
      this.isAuthentificated=true;
      this.roles=this.users[username]['roles'];
      return true;
    }else{
      return false;
    }
  }
  
}

