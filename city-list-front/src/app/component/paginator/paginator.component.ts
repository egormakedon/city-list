import { Component, EventEmitter, Input, Output } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';

@Component({
  selector: 'app-paginator',
  templateUrl: './paginator.component.html',
  styleUrls: ['./paginator.component.css']
})
export class PaginatorComponent {
  @Input() length: number = 50;
  @Input() pageSize: number = 10;
  @Input() pageIndex: number = 0;
  @Input() pageSizeOptions: number[] = [5, 10, 25, 50];

  @Input() hidePageSize: boolean = false;
  @Input() showPageSizeOptions: boolean = true;
  @Input() showFirstLastButtons: boolean = true;
  @Input() disabled: boolean = false;

  @Output() page = new EventEmitter<PageEvent>();

  handlePageEvent(e: PageEvent): void {
    this.page.emit(e);
  }
}
