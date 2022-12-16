import { Component } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { City } from './city/city';
import { CityService } from './city/city.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  length: number = 0;
  pageSize: number = 10;
  pageIndex: number = 0;
  cities: City[] = [];

  constructor(private cityService: CityService) {
  }

  ngOnInit() {
    this.getAllCities();
  }

  handlePageEvent(e: PageEvent) {
    this.length = e.length;
    this.pageSize = e.pageSize;
    this.pageIndex = e.pageIndex;
    this.getAllCities();
  }

  private getAllCities() {
    this.cityService.getAllCities(this.pageIndex, this.pageSize).subscribe(data => {
      this.cities = data.content;
      this.length = data.totalElements;
    });
  }
}
