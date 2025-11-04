package dev.sospets.sosproject.Specialty;

import org.springframework.stereotype.Component;

@Component
public class SpecialtyMapper {

    public Specialty map(SpecialtyRequestDto specialtyRequestDto){
        Specialty specialty = new Specialty();
        specialty.setId(specialtyRequestDto.getId());
        specialty.setName(specialtyRequestDto.getName());
        return specialty;
    }

    public SpecialtyRequestDto map(Specialty specialty){
        SpecialtyRequestDto specialtyRequestDto = new SpecialtyRequestDto();
        specialtyRequestDto.setId(specialty.getId());
        specialtyRequestDto.setName(specialty.getName());
        return specialtyRequestDto;
    }

}
