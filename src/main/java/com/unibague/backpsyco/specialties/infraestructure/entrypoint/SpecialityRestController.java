package com.unibague.backpsyco.specialties.infraestructure.entrypoint;

import com.unibague.backpsyco.specialties.domain.model.Specialty;
import com.unibague.backpsyco.specialties.domain.usecase.SpecialityUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specialties")
@RequiredArgsConstructor
public class SpecialityRestController {

    private final SpecialityUseCase specialityUseCase;

    @GetMapping("/all")
    public ResponseEntity<List<Specialty>> getAllSpecialties() {
        List<Specialty> specialties = specialityUseCase.getAllSpecialties();
        if (specialties.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(specialties, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Specialty> saveSpecialty(@RequestBody Specialty specialty) {
        Specialty savedSpecialty = specialityUseCase.saveSpecialty(specialty);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSpecialty);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSpecialty(@PathVariable("id") int specialtyId) {
        try {
            if(specialityUseCase.deleteSpecialty(specialtyId)){
                return ResponseEntity.ok("Especialidad eliminada correctamente");
            }
            return ResponseEntity.ok("Especialidad no encontrada");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hubo un error al eliminar la especialidad. No puede estar vinculada a un Psicologo");
        }


    }

    @PutMapping("/{id}")
    public ResponseEntity<Specialty> updateSpecialty(@PathVariable("id") int specialtyId, @RequestBody Specialty specialty) {
        specialty.setId(specialtyId);
        boolean isUpdated = specialityUseCase.updateSpecialty(specialty);
        if (isUpdated) {
            return ResponseEntity.ok(specialty);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}