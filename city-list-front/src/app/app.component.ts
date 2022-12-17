import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { City } from './domain/city';
import { CityService } from './service/city.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  length: number = 0;
  pageSize: number = 10;
  pageIndex: number = 0;
  loading: boolean = false;
  cities: City[] = [];

  constructor(private cityService: CityService) {
  }

  ngOnInit(): void {
    this.getAllCities();
  }

  handlePageEvent(e: PageEvent): void {
    this.length = e.length;
    this.pageSize = e.pageSize;
    this.pageIndex = e.pageIndex;
    this.getAllCities();
  }

  private getAllCities(): void {
    this.loading = true;
    this.cityService.getAllCities(this.pageIndex, this.pageSize).subscribe(data => {
      this.cities = data.content;
      this.length = data.totalElements;
      this.loading = false;
    });
  }
}
