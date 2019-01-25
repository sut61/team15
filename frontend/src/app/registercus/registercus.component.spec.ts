import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistercusComponent } from './registercus.component';

describe('RegistercusComponent', () => {
  let component: RegistercusComponent;
  let fixture: ComponentFixture<RegistercusComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistercusComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistercusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
