import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditornextComponent } from './editornext.component';

describe('EditornextComponent', () => {
  let component: EditornextComponent;
  let fixture: ComponentFixture<EditornextComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditornextComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditornextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
