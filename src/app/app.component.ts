import {Component, OnInit} from '@angular/core';
import { Product } from './interfaces/Product';
import { ProductService} from './services/product.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent implements OnInit {
  title = 'Parts Platform';
  products: Product[];
  constructor(private productService: ProductService) {}
  ngOnInit() {
    this.getProducts();
  }

  getProducts(): void {
    this.productService.getProducts()
        .subscribe(products => this.products = products);
  }
}
