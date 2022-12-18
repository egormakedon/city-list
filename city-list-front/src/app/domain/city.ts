export class City {
  private _id: number | undefined;
  private _name: string | undefined;
  private _photoUrl: string | undefined;

  constructor() {
  }

  get id(): number | undefined {
    return this._id;
  }

  set id(value: number | undefined) {
    this._id = value;
  }

  get name(): string | undefined {
    return this._name;
  }

  set name(value: string | undefined) {
    this._name = value;
  }

  get photoUrl(): string | undefined {
    return this._photoUrl;
  }

  set photoUrl(value: string | undefined) {
    this._photoUrl = value;
  }
}
