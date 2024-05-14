import { Component, OnInit } from '@angular/core';
import { FoodService } from '../food.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-orderitems',
  templateUrl: './orderitems.component.html',
  styleUrls: ['./orderitems.component.css']
})
export class OrderitemsComponent implements OnInit {

  constructor(private fs:FoodService,private r:ActivatedRoute) { }
orderitems:any = []; 
orderid:any;
  ngOnInit(): void {
    this.r.paramMap.subscribe(
      (params)=>{
        this.orderid= params.get("id");
      }
    )
    this.getOrders();
    console.log(this.orderid);
  }

  getOrders(){
    this.fs.fetchOrderItems(this.orderid).subscribe(
      (data: any)=>{
        this.orderitems=data;
      }
     )
  }

}
