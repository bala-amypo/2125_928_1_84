package com.example.demo.repository;

import com.example.demo.model.ServicePart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;   // ✅ MISSING IMPORT FIXED

public interface ServicePartRepository extends JpaRepository<ServicePart, Long> {

    List<ServicePart> findByServiceEntryId(Long entryId);
}
