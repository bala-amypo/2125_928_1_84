package com.example.demo.controller;

import com.example.demo.model.VerificationLog;
import com.example.demo.service.VerificationLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/verification-logs")
@Tag(name = "Verification Logs")
public class VerificationLogController {

    private final VerificationLogService service;

    public VerificationLogController(VerificationLogService service) {
        this.service = service;
    }

    @PostMapping
    public VerificationLog create(@RequestBody VerificationLog log) {
        return service.createLog(log);
    }

    @GetMapping("/{id}")
    public VerificationLog get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/entry/{entryId}")
    public List<VerificationLog> logs(@PathVariable Long entryId) {
        return service.getLogsForEntry(entryId);
    }
}
