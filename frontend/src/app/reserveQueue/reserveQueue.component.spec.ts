import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReserveQueueComponent } from './reserveQueue.component';

describe('ReserveQueueComponent', () => {
  let component: ReserveQueueComponent;
  let fixture: ComponentFixture<ReserveQueueComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReserveQueueComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReserveQueueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
