import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { ActivatedRoute, Router } from '@angular/router';
import { City } from '../../domain/city';
import { Paginator } from '../../domain/paginator';
import { CityService } from '../../service/city.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  paginator: Paginator = new Paginator();
  loading: boolean = false;
  cities: City[] = [];
  searchName: string = '';

  constructor(private cityService: CityService, private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.getAllCities();
  }

  handlePageEvent(e: PageEvent): void {
    this.paginator.length = e.length;
    this.paginator.pageSize = e.pageSize;
    this.paginator.pageIndex = e.pageIndex;
    this.getAllOrSearch();
  }

  handleSearchName(name: string): void {
    this.paginator.length = 0;
    this.paginator.pageIndex = 0;
    this.searchName = name.trim().toLowerCase();
    this.getAllOrSearch();
  }

  editCity(city: City): void {
    this.router.navigate(['/edit/city', city.id, { city: JSON.stringify(city) }]);
  }

  private getAllCities(): void {
    this.loading = true;
    this.cityService.getAllCities(this.paginator.pageIndex, this.paginator.pageSize).subscribe(data => {
      this.cities = data.content;
      this.paginator.length = data.totalElements;
      this.loading = false;
    });
  }

  private searchCities(): void {
    this.loading = true;
    this.cityService.searchCities(this.searchName, this.paginator.pageIndex, this.paginator.pageSize).subscribe(data => {
      this.cities = data.content;
      this.paginator.length = data.totalElements;
      this.loading = false;
    });
  }

  private getAllOrSearch(): void {
    if (this.searchName === '') {
      this.getAllCities();
    } else {
      this.searchCities();
    }
  }
}
