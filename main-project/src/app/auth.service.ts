import { Injectable, OnInit } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class AuthService implements CanActivate {

  constructor(private r:Router) { }
  
 
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    let loggedIn;
    let role = localStorage.getItem('role');
    if(role === "admin"){
      return true;
    }else if(role==='user'){
      loggedIn = localStorage.getItem('id');
      return true;
    }else {
      this.r.navigate(['/login']);
      return false;
    }
  }
}
