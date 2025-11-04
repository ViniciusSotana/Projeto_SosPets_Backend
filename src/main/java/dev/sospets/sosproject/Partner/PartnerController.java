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
    public ResponseEntity<List<PartnerResponseDto>> getPartner() {
        List<PartnerResponseDto> lPartners = partnerService.getAllPartners();
        return ResponseEntity.ok(lPartners);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartnerResponseDto> getPartnerById(@PathVariable Long id) {
        PartnerResponseDto partner = partnerService.getPartnerById(id);
        if (partner != null) {
            return ResponseEntity.ok(partner);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PartnerResponseDto> addPartner(@RequestBody @Valid PartnerRequestDto PartnerRequestDto) {
        PartnerResponseDto createdPartner = partnerService.addPartner(PartnerRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPartner);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartnerResponseDto> updatePartner(@PathVariable Long id, @RequestBody @Valid PartnerRequestDto PartnerRequestDto) {
        PartnerResponseDto updatedPartner = partnerService.updatePartner(id, PartnerRequestDto);
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
