package com.example.demo.service;

import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServicePartRepository;
import com.example.demo.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePartService {

    private final ServicePartRepository repo;

    public ServicePartService(ServicePartRepository repo) {
        this.repo = repo;
    }
    public ServicePart createPart(ServicePart part) {
        return repo.save(part);
    }
    public ServicePart getPartById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ServicePart not found"));
    }
    public List<ServicePart> getPartsForEntry(Long entryId) {
        return repo.findByServiceEntry_Id(entryId);
    }
}
