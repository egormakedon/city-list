import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { City } from '../../domain/city';
import { CityService } from '../../service/city.service';

@Component({
  selector: 'app-city-edit',
  templateUrl: './city-edit.component.html',
  styleUrls: ['./city-edit.component.css']
})
export class CityEditComponent implements OnInit {
  city: City = new City();
  submitted: boolean = false;

  constructor(private cityService: CityService, private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.initCity();
  }

  onSubmit(): void {
    this.submitted = true;
    this.updateCity();
    this.router.navigate(['']);
    this.submitted = false;
  }

  navigateToMain(): void {
    this.router.navigate(['']);
  }

  private initCity(): void {
    if (this.route.snapshot.paramMap.has('city')) {
      this.city = JSON.parse(<string>this.route.snapshot.paramMap.get('city'));
    } else {
      const id = parseInt(<string>this.route.snapshot.paramMap.get('id'));
      this.getCity(id);
    }
  }

  private getCity(id: number): void {
    this.cityService.getCity(id).subscribe(data => {
      this.city = data;
    });
  }

  private updateCity(): void {
    this.cityService.updateCity(this.city.id, this.city).subscribe(data => {
      this.city = data;
    })
  }
}
