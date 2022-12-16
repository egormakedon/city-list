import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { apiCities } from '../../api/api.cities';
import { apiPaging } from '../../api/api.paging';
import { environment } from '../../environments/environment';
import { City } from './city';
import { CityPage } from './city.page';

@Injectable({
  providedIn: 'root'
})
export class CityService {
  private readonly citiesUrl: string;
  private readonly citiesSearchUrl: string;

  constructor(private http: HttpClient) {
    this.citiesUrl = environment.apiUrl + apiCities.citiesUrl;
    this.citiesSearchUrl = environment.apiUrl + apiCities.citiesSearchUrl;
  }

  public getAllCities(page: number | null = null, size: number | null = null): Observable<CityPage> {
    let queryParams = new HttpParams();
    queryParams = page ? queryParams.append(apiPaging.pageParam, page) : queryParams;
    queryParams = size ? queryParams.append(apiPaging.sizeParam, size) : queryParams;

    return this.http.get<CityPage>(this.citiesUrl, {params: queryParams});
  }

  public searchCities(name: string, page: number | null = null, size: number | null = null): Observable<CityPage> {
    let queryParams = new HttpParams();
    queryParams = queryParams.append(apiCities.nameParam, name);
    queryParams = page ? queryParams.append(apiPaging.pageParam, page) : queryParams;
    queryParams = size ? queryParams.append(apiPaging.sizeParam, size) : queryParams;

    return this.http.get<CityPage>(this.citiesSearchUrl, {params: queryParams});
  }

  public updateCity(city: City): Observable<City> {
    const url = `${this.citiesUrl}/${city.id}`;
    return this.http.put<City>(url, city);
  }
}
