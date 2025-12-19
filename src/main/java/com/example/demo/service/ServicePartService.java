package com.example.demo.service;

import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServicePartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePartService {

    private final ServicePartRepository repo;

    public ServicePartService(ServicePartRepository repo) {
        this.repo = repo;
    }

    public List<ServicePart> getPartsForEntry(Long entryId) {
        return repo.findByServiceEntry_Id(entryId);
    }

    public ServicePart create(ServicePart part) {
        return repo.save(part);
    }
}
