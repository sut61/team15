import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StockmedicineComponent } from './stockmedicine.component';

describe('StockmedicineComponent', () => {
  let component: StockmedicineComponent;
  let fixture: ComponentFixture<StockmedicineComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StockmedicineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StockmedicineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
