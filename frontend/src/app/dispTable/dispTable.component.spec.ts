import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QueueTableComponent } from './queueTable.component';

describe('QueueTableComponent', () => {
  let component: QueueTableComponent;
  let fixture: ComponentFixture<QueueTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QueueTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QueueTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
