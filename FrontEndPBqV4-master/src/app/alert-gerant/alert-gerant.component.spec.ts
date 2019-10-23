import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlertGerantComponent } from './alert-gerant.component';

describe('AlertGerantComponent', () => {
  let component: AlertGerantComponent;
  let fixture: ComponentFixture<AlertGerantComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlertGerantComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlertGerantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
