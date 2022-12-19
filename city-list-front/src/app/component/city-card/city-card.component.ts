import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-city-card',
  templateUrl: './city-card.component.html',
  styleUrls: ['./city-card.component.css']
})
export class CityCardComponent {
  @Input() id: number | undefined;
  @Input() name: string | undefined;
  @Input() photoUrl: string | undefined;
}
