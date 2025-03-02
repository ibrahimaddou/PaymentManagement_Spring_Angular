
/*export const authGuard: CanActivateFn = (route, state) => {
  return true;
};*/

import { Injectable } from "@angular/core";
import { AuthService } from "../services/auth.service";
import { ActivatedRouteSnapshot, GuardResult, MaybeAsync, Router, RouterStateSnapshot } from "@angular/router";

@Injectable()
export class AuthGuard{
  constructor(private authService : AuthService,private  router : Router){

  }
  canActivate(route : ActivatedRouteSnapshot, state: RouterStateSnapshot):MaybeAsync<GuardResult>{
    if (this.authService.isAuthentificated) {
      return true;
    }else{
      this.router.navigateByUrl('/login');
      return false;
    }
    
  }
}

