import { Component, OnInit } from '@angular/core';
import { FoodService } from '../food.service';

// interface Food {
//   food_id: any,number: any;
//   food_name: string;
//   price: number;
//   quantity: number;
// }


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  foods:any=null;
  // foodid:any;
  // foodname="";
  // quantity: any;
  // price: any;
  // id=null;
  constructor(private ms:FoodService){

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
 
}

