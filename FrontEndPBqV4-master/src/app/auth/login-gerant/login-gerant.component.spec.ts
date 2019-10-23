import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginGerantComponent } from './login-gerant.component';

describe('LoginGerantComponent', () => {
  let component: LoginGerantComponent;
  let fixture: ComponentFixture<LoginGerantComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginGerantComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginGerantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
