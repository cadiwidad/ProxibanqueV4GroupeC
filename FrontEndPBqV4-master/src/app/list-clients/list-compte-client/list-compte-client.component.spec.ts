import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListCompteClientComponent } from './list-compte-client.component';

describe('ListCompteClientComponent', () => {
  let component: ListCompteClientComponent;
  let fixture: ComponentFixture<ListCompteClientComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListCompteClientComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListCompteClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
