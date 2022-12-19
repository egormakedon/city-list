import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatPaginatorModule } from '@angular/material/paginator';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CityCardComponent } from './component/city-card/city-card.component';
import { PaginatorComponent } from './component/paginator/paginator.component';
import { CitySearchComponent } from './component/city-search/city-search.component';
import { MainComponent } from './component/main/main.component';
import { CityEditComponent } from './component/city-edit/city-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    PaginatorComponent,
    CityCardComponent,
    CitySearchComponent,
    MainComponent,
    CityEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatPaginatorModule,
    BrowserAnimationsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
