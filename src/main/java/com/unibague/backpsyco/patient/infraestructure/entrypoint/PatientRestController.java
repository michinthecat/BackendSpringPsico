package com.unibague.backpsyco.patient.infraestructure.entrypoint;

import com.unibague.backpsyco.patient.domain.model.Patient;
import com.unibague.backpsyco.patient.domain.usecase.PatientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientRestController {

    private final PatientUseCase patientUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") int patientId) {
        Patient patient = patientUseCase.getPatientById(patientId);
        if (patient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(patient);
    }

    @PutMapping
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientUseCase.updatePatient(patient));
    }

    @PatchMapping("/{id}/notes")
    public ResponseEntity<Patient> updatePatientNotes(@PathVariable("id") int patientId, @RequestBody String newNotes) {
        return ResponseEntity.ok(patientUseCase.updatePatientNotes(patientId, newNotes));
    }
}