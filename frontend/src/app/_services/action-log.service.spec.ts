import { TestBed } from '@angular/core/testing';

import { ActionLogService } from './action-log.service';

describe('ActionLogsService', () => {
  let service: ActionLogService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ActionLogService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
