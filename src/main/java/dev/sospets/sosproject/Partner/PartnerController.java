package dev.sospets.sosproject.Partner;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partners")
public class PartnerController {

    private final PartnerService partnerService;

    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @GetMapping
    public ResponseEntity<List<PartnerRequestDto>> getPartner() {
        List<PartnerRequestDto> lPartners = partnerService.getAllPartners();
        return ResponseEntity.ok(lPartners);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartnerRequestDto> getPartnerById(@PathVariable Long id) {
        PartnerRequestDto partner = partnerService.getPartnerById(id);
        if (partner != null) {
            return ResponseEntity.ok(partner);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PartnerRequestDto> addPartner(@RequestBody @Valid PartnerRequestDto PartnerRequestDto) {
        PartnerRequestDto createdPartner = partnerService.addPartner(PartnerRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPartner);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartnerRequestDto> updatePartner(@PathVariable Long id, @RequestBody @Valid PartnerRequestDto PartnerRequestDto) {
        PartnerRequestDto updatedPartner = partnerService.updatePartner(id, PartnerRequestDto);
        if (updatedPartner != null) {
            return ResponseEntity.ok(updatedPartner);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePartner(@PathVariable Long id) {
        if (partnerService.getPartnerById(id) != null) {
            partnerService.deletePartner(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parceiro não encontrado");
        }
    }
    
}
