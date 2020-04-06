import { Injectable } from '@angular/core';
import { Observable, of} from 'rxjs';
import { Product } from '../interfaces/Product';
import { HttpClient } from '@angular/common/http';
import { catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  constructor(private http: HttpClient) { }

  private productsUrl = 'https://8lvzzzoudb.execute-api.us-east-2.amazonaws.com/default/PartsPlatformAPI';
  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.productsUrl).pipe(
      catchError(this.handleError<Product[]>('getProducts', []))
    );
  }
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      alert('Failed to load product data.');
      return of(result as T);
    };
  }
}
