package dev.sospets.sosproject.Specialty;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specialties")
public class SpecialtyController {
    private final SpecialtyService specialtyService;

    public SpecialtyController(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @GetMapping
    public ResponseEntity<List<SpecialtyRequestDto>> getSpecialty() {
        List<SpecialtyRequestDto> lSpecialties = specialtyService.getAllSpecialties();
        return ResponseEntity.ok(lSpecialties);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecialtyRequestDto> getSpecialtyById(@PathVariable Long id) {
        SpecialtyRequestDto specialty = specialtyService.getSpecialtyById(id);
        if (specialty != null) {
            return ResponseEntity.ok(specialty);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<SpecialtyRequestDto> addSpecialty(@RequestBody @Valid SpecialtyRequestDto specialtyRequestDto) {
        SpecialtyRequestDto createdspecialty = specialtyService.addSpecialty(specialtyRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdspecialty);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpecialtyRequestDto> updateSpecialty(@PathVariable Long id, @RequestBody @Valid SpecialtyRequestDto specialtyRequestDto) {
        SpecialtyRequestDto updatedSpecialty = specialtyService.updateSpecialty(id, specialtyRequestDto);
        if (updatedSpecialty != null) {
            return ResponseEntity.ok(updatedSpecialty);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSpecialty(@PathVariable Long id) {
        if (specialtyService.getSpecialtyById(id) != null) {
            specialtyService.deleteSpecialty(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Especialidade não encontrado");
        }
    }
}
