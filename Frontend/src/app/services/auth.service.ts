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
  constructor() { }
  public login(username:string, password : string):boolean {
    if (this.users[username]&& this.users[username]['password']==password) {
      return true;
    }else{
      return false;
    }
  }
  
}

