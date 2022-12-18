import { City } from './city';

export class CityPage {
  private _content: City[] = [];
  private _totalElements: number = 0;

  constructor() {
  }

  get content(): City[] {
    return this._content;
  }

  set content(value: City[]) {
    this._content = value;
  }

  get totalElements(): number {
    return this._totalElements;
  }

  set totalElements(value: number) {
    this._totalElements = value;
  }
}
