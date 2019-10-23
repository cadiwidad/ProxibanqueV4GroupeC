import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderGerantComponent } from './header-gerant.component';

describe('HeaderGerantComponent', () => {
  let component: HeaderGerantComponent;
  let fixture: ComponentFixture<HeaderGerantComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeaderGerantComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderGerantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
