import { Component, EventEmitter, Input, OnDestroy, OnInit, Output } from '@angular/core';
import { debounceTime, distinctUntilChanged, Subject } from 'rxjs';

@Component({
  selector: 'app-city-search',
  templateUrl: './city-search.component.html',
  styleUrls: ['./city-search.component.css']
})
export class CitySearchComponent implements OnInit, OnDestroy {
  modelName: string = '';
  modelNameSubject: Subject<string> = new Subject<string>();

  @Input() debounceTime: number = 500;
  @Output() name: EventEmitter<string> = new EventEmitter<string>();

  ngOnInit(): void {
    this.modelNameSubject
      .pipe(
        debounceTime(this.debounceTime),
        distinctUntilChanged())
      .subscribe(value => this.name.emit(value));
  }

  ngOnDestroy(): void {
    this.modelNameSubject.unsubscribe();
  }

  handleModelNameChanged(name: string): void {
    this.modelNameSubject.next(name);
  }
}
