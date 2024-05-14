import { Component, OnInit } from '@angular/core';
import { FoodService } from '../food.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  customerid:any;
  constructor(private fs:FoodService,private r:Router) { }
  showform=true;
  s="";
  c=localStorage.getItem("id");
  orders:any=null;
  count=0;
  ngOnInit(): void {
    this.count=0;
    
  }
  order(){
    let body={customer:{
      customer_id:this.c
    }}

    this.fs.postorder(body).subscribe(
      (res: any)=>{
        if(res==null && this.count==0){
          alert("Cart is Empty Add some Items");
          this.r.navigate(['/cart']);
        }
        else{
          this.count=1;
          this.getOrders();
          this.s="Ordered Successfully!!";
       }
      }
    )
  
  }
  clearform() {
   this.c=null;
  }
  submitForm(form:NgForm){
    if(form.valid){
      this.order();
    }
}
yourOrders(){
  this.showform=!this.showform;
  this.getOrders();
}
toCart(){
  this.r.navigate(["/cart"]);
}
getOrders(){
  this.fs.fetchOrders(this.c).subscribe(
    (data: any)=>{
      this.orders=data;
      this.fs.orders=data;
    }
   )
}
viewItems(id:any){
  this.r.navigate(["/orderitems",id]);
}
cancelOrder(id: any){
  this.fs.deleteOrder(id).subscribe((res)=>{this.getOrders()})
}
}
