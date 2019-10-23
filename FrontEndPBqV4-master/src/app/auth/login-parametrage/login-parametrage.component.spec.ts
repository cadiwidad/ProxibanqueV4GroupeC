import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginParametrageComponent } from './login-parametrage.component';

describe('LoginParametrageComponent', () => {
  let component: LoginParametrageComponent;
  let fixture: ComponentFixture<LoginParametrageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginParametrageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginParametrageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
