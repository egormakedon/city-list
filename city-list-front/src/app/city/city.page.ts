import { City } from './city';

export class CityPage {
  private _content: City[] | undefined;
  private _totalPages: number | undefined;
  private _totalElements: number | undefined;

  constructor() {
  }

  get content(): City[] | undefined {
    return this._content;
  }

  set content(value: City[] | undefined) {
    this._content = value;
  }

  get totalPages(): number | undefined {
    return this._totalPages;
  }

  set totalPages(value: number | undefined) {
    this._totalPages = value;
  }

  get totalElements(): number | undefined {
    return this._totalElements;
  }

  set totalElements(value: number | undefined) {
    this._totalElements = value;
  }
}
