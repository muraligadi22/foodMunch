import { Component, OnInit } from '@angular/core';
import { FoodService } from '../food.service';
import { Router } from '@angular/router';

interface Food {
  food_id: any;
  food_name: string;
  price: number;
  quantity: number;
}


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  foods:any=null;

  formHeader="Add Food";
  foodid:any;
  foodname="";
  quantity: any;
  price: any;
  id=null;
  showForm=false;
  
  constructor(private r: Router,private ms:FoodService){

  }
  
  ngOnInit(): void {
    
  this.getFood();

  }
  getFood(){
    this.ms.fetchFoods().subscribe(
      (data)=>{
        this.foods=data;
      },
      (error)=>{
        console.log("error");
      }
     )
  }
  deleteFood(id: any){
    this.ms.deleteFood(id).subscribe((res)=>{this.getFood()})
  }
  openForm(data: Food| null = null) {
   
    this.showForm = true;
    if (data) {
      this.formHeader="Edit Food";
      this.foodid=data.food_id;
      this.foodname = data.food_name;
      this.price = data.price;
      this.quantity = data.quantity;
    }
    else{
      this.formHeader="Add Food";
      this.clearform();
    }
  }
  closeForm(){
    this.showForm=false;
    this.clearform();
  }
  clearform() {
    this.foodid=null;
    this.foodname='';
    this.price=null;
    this.quantity=null;
  }
  saveFood(){
    this.showForm=false;
    let body={
      food_id:this.foodid,
      food_name:this.foodname,
      price:this.price,
      quantity:this.quantity
    }
    if(this.foodid){
     // body['food_id']=this.foodid;
      this.ms.putFood(body).subscribe(
        (res: any)=>{
          this.getFood();
        }
      )
    }
    else{
      this.ms.postFood(body).subscribe(
        (res: any)=>{
          this.getFood();
        }
      )
    }
  }

  logOut(){
    this.r.navigate(['/login']);
    localStorage.removeItem('role');

    if(localStorage.getItem('id')){
      localStorage.removeItem('id');
    }
    this.r.navigate(['/login']);
  }
}

