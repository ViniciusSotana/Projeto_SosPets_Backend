package dev.sospets.sosproject.Partner;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartnerService {

    private final PartnerRepository partnerRepository;
    private final PartnerMapper partnerMapper;

    public PartnerService(PartnerRepository partnerRepository, PartnerMapper partnerMapper) {
        this.partnerRepository = partnerRepository;
        this.partnerMapper = partnerMapper;
    }
    
    
    public List<PartnerResponseDto> getAllPartners() {
        List<Partner> lPartners = partnerRepository.findAll();
        return lPartners.stream()
                .map(partnerMapper::toResponse)
                .collect(Collectors.toList());
    }

    public PartnerResponseDto getPartnerById(Long id){
        Optional<Partner> partner = partnerRepository.findById(id);
        return partner.map(partnerMapper::toResponse).orElse(null);
    }

    public PartnerResponseDto addPartner(PartnerRequestDto partnerRequestDto){
        Partner partner = partnerMapper.map(partnerRequestDto);
        Partner savedPartner = partnerRepository.save(partner);
        return partnerMapper.toResponse(savedPartner);
    }

    public PartnerResponseDto updatePartner(Long id, PartnerRequestDto partnerRequestDto){
        Optional<Partner> partner = partnerRepository.findById(id);
        if(partner.isPresent()){
            Partner existentPartner = partner.get();
            existentPartner.setName(partnerRequestDto.getName());
            existentPartner.setAddress(partnerRequestDto.getAddress());
            existentPartner.setPhone(partnerRequestDto.getPhone());
            existentPartner.setEmail(partnerRequestDto.getEmail());
            existentPartner.setSpecialties(partnerRequestDto.getSpecialties());
            existentPartner.setSiteUrl(partnerRequestDto.getSiteUrl());
            Partner savedPartner = partnerRepository.save(existentPartner);
            return partnerMapper.toResponse(savedPartner);
        }
        return null;
    }

    public void deletePartner(Long id){
        Optional<Partner> partner = partnerRepository.findById(id);
        if(partner.isPresent()){
            partnerRepository.delete(partner.get());
        }
    }
    
    
}
