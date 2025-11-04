package dev.sospets.sosproject.Partner;

import org.springframework.stereotype.Component;

@Component
public class PartnerMapper {

    public Partner map(PartnerRequestDto partnerRequestDto) {
        Partner partner = new Partner();
        partner.setId(partnerRequestDto.getId());
        partner.setName(partnerRequestDto.getName());
        partner.setEmail(partnerRequestDto.getEmail());
        partner.setPhone(partnerRequestDto.getPhone());
        partner.setAddress(partnerRequestDto.getAddress());
        partner.setSiteUrl(partnerRequestDto.getSiteUrl());
        partner.setSpecialties(partnerRequestDto.getSpecialties());
        return partner;
    }

    public PartnerRequestDto map(Partner partner) {
        PartnerRequestDto partnerRequestDto = new PartnerRequestDto();
        partnerRequestDto.setId(partner.getId());
        partnerRequestDto.setName(partner.getName());
        partnerRequestDto.setEmail(partner.getEmail());
        partnerRequestDto.setPhone(partner.getPhone());
        partnerRequestDto.setAddress(partner.getAddress());
        partnerRequestDto.setSiteUrl(partner.getSiteUrl());
        partnerRequestDto.setSpecialties(partner.getSpecialties());
        return partnerRequestDto;
    }

    public PartnerResponseDto toResponse(Partner partner){
        PartnerResponseDto partnerResponseDto = new PartnerResponseDto();
        partnerResponseDto.setId(partner.getId());
        partnerResponseDto.setName(partner.getName());
        partnerResponseDto.setEmail(partner.getEmail());
        partnerResponseDto.setPhone(partner.getPhone());
        partnerResponseDto.setAddress(partner.getAddress());
        partnerResponseDto.setSiteUrl(partner.getSiteUrl());
        partnerResponseDto.setSpecialties(partner.getSpecialties());

        return partnerResponseDto;
    }

}
