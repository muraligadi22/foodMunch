import { state } from '@angular/animations';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminAuthService implements CanActivate{

  
  constructor(private r: Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    let role = localStorage.getItem('role');
    if(role === 'admin'){
      return true;
    }else{
      this.r.navigate(['/login']);
      alert("UnAuthorized Access");
      return false;
    }
  }


}
