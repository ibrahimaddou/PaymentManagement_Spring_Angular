
/*export const authGuard: CanActivateFn = (route, state) => {
  return true;
};*/

import { Injectable } from "@angular/core";
import { AuthService } from "../services/auth.service";
import { ActivatedRouteSnapshot, GuardResult, MaybeAsync, RouterStateSnapshot } from "@angular/router";

@Injectable()
export class AuthGuard{
  constructor(private authService : AuthService){

  }
  canActivate(route : ActivatedRouteSnapshot, state: RouterStateSnapshot):MaybeAsync<GuardResult>{
    return this.authService.isAuthentificated;
  }
}

