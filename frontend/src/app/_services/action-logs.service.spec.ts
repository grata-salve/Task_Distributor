import { TestBed } from '@angular/core/testing';

import { ActionLogsService } from './action-logs.service';

describe('ActionLogsService', () => {
  let service: ActionLogsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ActionLogsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
