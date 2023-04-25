package com.taskDistributor.controllers;

import com.taskDistributor.services.ActionLogsService;
import com.taskDistributor.services.dtos.ActionLogsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class ActionLogsController {

    private final ActionLogsService actionLogsService;

    @GetMapping("/getById/{logId}")
    @ResponseStatus(HttpStatus.OK)
    public ActionLogsDto getActionLog(@PathVariable Long logId) {
        return actionLogsService.getActionLogsById(logId);
    }

    @GetMapping("/allByUserId/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ActionLogsDto> filterByUserId(@PathVariable Long userId) {
        return actionLogsService.getLogsByUserId(userId);
    }

    @GetMapping("/allByTaskId/{taskId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ActionLogsDto> filterByTaskId(@PathVariable Long taskId) {
        return actionLogsService.getLogsByTaskId(taskId);
    }
}
