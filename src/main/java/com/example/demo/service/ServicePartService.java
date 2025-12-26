package com.example.demo.service;

import com.example.demo.model.ServicePart;

import java.util.List;

public interface ServicePartService {

    ServicePart createPart(ServicePart part);

    ServicePart getById(Long id);

    List<ServicePart> getByEntry(Long entryId);
}
