package com.example.demo.service.impl;

import com.example.demo.model.VerificationLog;
import com.example.demo.model.ServiceEntry;
import com.example.demo.repository.VerificationLogRepository;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.service.VerificationLogService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VerificationLogServiceImpl implements VerificationLogService {

    private final VerificationLogRepository logRepo;
    private final ServiceEntryRepository entryRepo;

    public VerificationLogServiceImpl(VerificationLogRepository logRepo,
                                      ServiceEntryRepository entryRepo) {
        this.logRepo = logRepo;
        this.entryRepo = entryRepo;
    }

    @Override
    public VerificationLog createLog(VerificationLog log) {

        ServiceEntry entry = entryRepo.findById(log.getServiceEntry().getId())
                .orElseThrow(() -> new EntityNotFoundException("ServiceEntry not found"));

        log.setServiceEntry(entry);
        log.setVerifiedAt(LocalDateTime.now());

        return logRepo.save(log);
    }
}
