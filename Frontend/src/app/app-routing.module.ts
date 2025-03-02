import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { LoginComponent } from './login/login.component';
import { LoadClientsComponent } from './load-clients/load-clients.component';
import { PaymentsComponent } from './payments/payments.component';
import { LoadPaymentsComponent } from './load-payments/load-payments.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ClientsComponent } from './clients/clients.component';
import { AdminTemplateComponent } from './admin-template/admin-template.component';

const routes: Routes = [
  {path : "", component : LoginComponent},
  {path : "login", component : LoginComponent},
  {path : "admin", component : AdminTemplateComponent},

  {path : "home", component : HomeComponent},
  {path : "profile", component : ProfileComponent},
  {path : "loadClients", component : LoadClientsComponent},
  {path : "loadPayments", component : LoadPaymentsComponent},
  {path : "dashboard", component : DashboardComponent},
  {path : "clients", component : ClientsComponent},
  {path : "payments", component : PaymentsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
