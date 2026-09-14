// app.module.ts
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { UserComponent } from './user/user.component'; // Import UserComponent directly
import { AppComponent } from './app.component';

@NgModule({
  declarations: [UserComponent], // Declare UserComponent
  imports: [AppComponent, BrowserModule, HttpClientModule, AppRoutingModule],
  bootstrap: [],
})
export class AppModule {}
