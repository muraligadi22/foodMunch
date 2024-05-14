import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminComponent } from './admin/admin.component';
import { FoodService } from './food.service';
import { HttpClientModule} from '@angular/common/http';
import { AboutComponent } from './about/about.component';
import { HeaderComponent } from './header/header.component';
import { RouterModule ,Routes} from '@angular/router';

import { NotfoundComponent } from './notfound/notfound.component';
import { ContactComponent } from './contact/contact.component';
import { MenuComponent } from './menu/menu.component';
import { CartComponent } from './cart/cart.component';
import { OrderComponent } from './order/order.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { OrderitemsComponent } from './orderitems/orderitems.component';
import { RegisterComponent } from './register/register.component';
import { AuthService } from './auth.service';
import { AdminAuthService } from './admin-auth.service';
import { UserAuthService } from './user-auth.service';



const routes:Routes=[
 
  {
    path:'',component:LoginComponent
  },

  {
    path:'home',component:HomeComponent,canActivate:[AuthService,UserAuthService]
  },
  {
    path:'about',component:AboutComponent,canActivate:[AuthService,UserAuthService]
  },
  {
    path:'admin',component:AdminComponent,canActivate:[AuthService,AdminAuthService]
  },
  {
    path:'login',component:LoginComponent
  },
  {
    path:'contact',component:ContactComponent,canActivate:[AuthService,UserAuthService]
  },
  {
    path:'menu',component:MenuComponent,canActivate:[AuthService,UserAuthService]
  },
  {
    path:'order',component:OrderComponent,canActivate:[AuthService,UserAuthService]
  },
  {
    path:'orderitems/:id',component:OrderitemsComponent,canActivate:[AuthService,UserAuthService]
  },
  {
    path:'cart',component:CartComponent,canActivate:[AuthService,UserAuthService]
  },
  {
    path:'register',component:RegisterComponent
  },
  {
    path:'**',component:NotfoundComponent
  }

]

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    AboutComponent,
    HeaderComponent,
    ContactComponent,
    MenuComponent,
    CartComponent,
    OrderComponent,
    LoginComponent,
    HomeComponent,
    OrderitemsComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [FoodService,AuthService,AdminAuthService,UserAuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
