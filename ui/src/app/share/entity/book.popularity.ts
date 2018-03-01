

export class BookPopularity{
  private _id: any;
  private _name: string;
  private _author: string;
  private _popularity: any;

  constructor(id: any, popularity: any, name: string, author: string) {
    this._id = id;
    this._popularity = popularity;
    this._name = name;
    this._author = author;
  }

  set id(value: any) {
    this._id = value;
  }

  set popularity(value: any) {
    this._popularity = value;
  }

  set name(value: string) {
    this._name = value;
  }

  set author(value: string) {
    this._author = value;
  }

  get id(): any {
    return this._id;
  }

  get popularity(): any {
    return this._popularity;
  }

  get name(): string {
    return this._name;
  }

  get author(): string {
    return this._author;
  }
}
