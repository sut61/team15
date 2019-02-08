import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrintstockComponent } from './printstock.component';

describe('PrintstockComponent', () => {
  let component: PrintstockComponent;
  let fixture: ComponentFixture<PrintstockComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrintstockComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrintstockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
