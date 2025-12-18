 package com.example.demo.service;

import com.example.demo.model.VerificationLog;
import com.example.demo.repository.VerificationLogRepository;
import com.example.demo.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationLogService {

    private final VerificationLogRepository repo;

    public VerificationLogService(VerificationLogRepository repo) {
        this.repo = repo;
    }

    public VerificationLog createLog(VerificationLog log) {
        return repo.save(log);
    }

    public VerificationLog getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Log not found"));
    }

    public List<VerificationLog> getLogsForEntry(Long entryId) {
        return repo.findByServiceEntryId(entryId);
    }
}
