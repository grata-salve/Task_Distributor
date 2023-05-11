package com.taskDistributor.controllers;

import com.taskDistributor.services.ActionLogService;
import com.taskDistributor.services.dtos.ActionLogDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class ActionLogController {

    private final ActionLogService actionLogService;

    @GetMapping("/get/{logId}")
    @ResponseStatus(HttpStatus.OK)
    public ActionLogDto getActionLog(@PathVariable Long logId) {
        return actionLogService.getActionLogsById(logId);
    }

    @GetMapping("/getUserLogs/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ActionLogDto> getActionLogsByUser(@PathVariable Long userId) {
        return actionLogService.getLogsByUserId(userId);
    }

    @GetMapping("/getTaskLogs/{taskId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ActionLogDto> getActionLogsByTask(@PathVariable Long taskId) {
        return actionLogService.getLogsByTaskId(taskId);
    }
}
