import { Component, OnInit } from '@angular/core';
import { FoodService } from '../food.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  foods:any=null;
  cartid:any;
  foodid:any;
  customerid:any;
  quantity:any;
  s:any;
  c:any;
  showform=true;
  constructor(private fs:FoodService) { }
  ngOnInit(): void {
    this.c=localStorage.getItem('id');
  }
  inc(food:any){
      food.quantity= food.quantity+1;
    this.fs.putCart(food).subscribe(
      (res: any)=>{
      }
    )
    
  }
  dec(food:any){
    if(food.quantity>1){
    food.quantity= food.quantity-1;
    this.fs.putCart(food).subscribe(
      (res: any)=>{
      }
    )
  }
}
  
  saveCartItem(){
    let body={
      //cart_id:this.cartid,
      food:{food_id:this.foodid},
      customer:{customer_id:this.c},
      quantity:this.quantity}
      this.fs.postCart(body).subscribe(
        (res: any)=>{
        this.getCart();
        },
        (err)=>{
          alert("No food Registered with the id entered");
        }
      )
      this.s="Item Added Successfully!!";
      this.clearform();
      
    }
    submitForm(form:NgForm){
      if(form.valid){
        //this.c=this.customerid;
        this.saveCartItem();
       // this.getCart();
      }
      this.showform=!this.showform;
  }
  clearform() {
   // this.c=this.customerid;
    this.foodid=null;
    this.customerid=null;
    this.quantity=null;
  }

  showForm(){
    this.showform=!this.showform;
    if(this.showform===false){
      this.getCart();
    }
  }

  getCart(){
    this.showform=!this.showform;
    this.fs.fetchCartById(this.c).subscribe(
      (data)=>{
        console.log(data);
        this.foods=data;
      }
     )
  }
  deleteFood(id:any){
    this.fs.deleteCartFood(id).subscribe((res)=>{this.getCart()})
  }
  }


