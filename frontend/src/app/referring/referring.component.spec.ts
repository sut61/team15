import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReferringComponent } from './referring.component';

describe('ReferringComponent', () => {
  let component: ReferringComponent;
  let fixture: ComponentFixture<ReferringComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReferringComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReferringComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
