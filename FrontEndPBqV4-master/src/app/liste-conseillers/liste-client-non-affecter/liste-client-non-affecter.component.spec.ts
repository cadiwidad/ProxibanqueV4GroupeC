import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeClientNonAffecterComponent } from './liste-client-non-affecter.component';

describe('ListeClientNonAffecterComponent', () => {
  let component: ListeClientNonAffecterComponent;
  let fixture: ComponentFixture<ListeClientNonAffecterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListeClientNonAffecterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListeClientNonAffecterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
