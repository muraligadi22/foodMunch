import { Component, OnInit } from '@angular/core';
import { FoodService } from '../food.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})

export class ContactComponent implements OnInit {

  name:string='';
  email:string='';
  message:string='';
  constructor(private ms:FoodService,private r:Router) { }

  ngOnInit(): void {
  }
  clearform() {
    this.name='';
    this.message='';
    this.email='';
    
  }
  submitForm(form:NgForm){
    if(form.valid){
      this.saveContact();
    }
}
 saveContact(){
  let body={
    name:this.name,
    email:this.email,
    message:this.message
  }
  this.ms.postContact(body).subscribe(
    (res: any)=>{
    }
  )
  this.r.navigate(["/home"]);
  this.clearform();
 }
 
 
}
