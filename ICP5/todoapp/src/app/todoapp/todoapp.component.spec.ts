import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TodoappComponent } from './todoapp.component';

describe('TodoappComponent', () => {
  let component: TodoappComponent;
  let fixture: ComponentFixture<TodoappComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TodoappComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TodoappComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
