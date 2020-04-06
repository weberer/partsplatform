import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-price-box',
  templateUrl: './price-box.component.html',
  styleUrls: ['./price-box.component.scss']
})
export class PriceBoxComponent implements OnInit {
  @Input() price: string;
  @Input() manufacturer: string;
  constructor() { }

  ngOnInit(): void {
  }

}
