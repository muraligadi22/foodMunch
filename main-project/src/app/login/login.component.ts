import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { FoodService } from '../food.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  c :string = "";
  customerId: any;
  customerEmail: string | undefined;
  password: string | undefined;
  constructor(private ath:AuthService,private fs:FoodService,private r:Router){}

  ngOnInit(): void {
    localStorage.clear();
  }
  submitForm(form:NgForm){
      console.log(form);
  }
  check1(form:NgForm){
    if(form.valid)
    return true;
  else{
  return false;
  }
  }

  login() {
    if(this.customerEmail==="admin@gmail.com" && this.password==="admin@123"){
      localStorage.setItem("role","admin");
      this.r.navigate(["/admin"]);
    }
    else{
    this.fs.UserExist({"email": this.customerEmail,"password": this.password}).subscribe(
      (data: any) => {
        if(data!==null){
         // console.log(data);
        this.customerId = data.customer_id;
       // console.log(data.customer_id);
        localStorage.setItem("id",data.customer_id);
        localStorage.setItem("role","user");
        localStorage.setItem("name",data.name);
        this.r.navigate(["/home"]);
        }
        else{
          alert("Invalid Credentials");
        }
      }
    )
    }
  }
  
}


