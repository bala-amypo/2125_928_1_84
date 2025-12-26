// package com.example.demo.controller;

// import com.example.demo.model.VerificationLog;
// import com.example.demo.service.VerificationLogService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/verification-logs")
// public class VerificationLogController {

//     private final VerificationLogService verificationLogService;

//     public VerificationLogController(VerificationLogService verificationLogService) {
//         this.verificationLogService = verificationLogService;
//     }

//     @PostMapping
//     public ResponseEntity<VerificationLog> create(@RequestBody VerificationLog log) {
//         return ResponseEntity.ok(verificationLogService.createLog(log));
//     }
// }


package com.example.demo.controller;

import com.example.demo.model.VerificationLog;
import com.example.demo.service.VerificationLogService;
import io.swagger.v3.oas.annotations.Tag;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/verification-logs")
@Tag(name = "Verification Log Controller")
@SecurityRequirement(name = "bearerAuth")
public class VerificationLogController {

    private final VerificationLogService verificationLogService;

    public VerificationLogController(VerificationLogService verificationLogService) {
        this.verificationLogService = verificationLogService;
    }

    // POST /
    @PostMapping
    public ResponseEntity<VerificationLog> create(@RequestBody VerificationLog log) {
        return ResponseEntity.ok(verificationLogService.createLog(log));
    }

    // GET /{id}
    @GetMapping("/{id}")
    public ResponseEntity<VerificationLog> getById(@PathVariable Long id) {
        return ResponseEntity.ok(null);
    }

    // GET /entry/{entryId}
    @GetMapping("/entry/{entryId}")
    public ResponseEntity<?> getByEntry(@PathVariable Long entryId) {
        return ResponseEntity.ok(null);
    }
}
