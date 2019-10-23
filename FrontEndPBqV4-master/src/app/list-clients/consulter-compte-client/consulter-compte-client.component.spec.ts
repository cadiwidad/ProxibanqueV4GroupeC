import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsulterCompteClientComponent } from './consulter-compte-client.component';

describe('ConsulterCompteClientComponent', () => {
  let component: ConsulterCompteClientComponent;
  let fixture: ComponentFixture<ConsulterCompteClientComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsulterCompteClientComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsulterCompteClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
