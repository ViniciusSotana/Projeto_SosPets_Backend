package dev.sospets.sosproject.Specialty;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SpecialtyService {

    private final SpecialtyRepository specialtyRepository;
    private final SpecialtyMapper specialtyMapper;

    public SpecialtyService(SpecialtyRepository specialtyRepository, SpecialtyMapper specialtyMapper) {
        this.specialtyRepository = specialtyRepository;
        this.specialtyMapper = specialtyMapper;
    }


    public List<SpecialtyRequestDto> getAllSpecialties() {
        List<Specialty> lspecialtys = specialtyRepository.findAll();
        return lspecialtys.stream()
                .map(specialtyMapper::map)
                .collect(Collectors.toList());
    }

    public SpecialtyRequestDto getSpecialtyById(Long id){
        Optional<Specialty> specialty = specialtyRepository.findById(id);
        return specialty.map(specialtyMapper::map).orElse(null);
    }

    public SpecialtyRequestDto addSpecialty(SpecialtyRequestDto specialtyRequestDto){
        Specialty specialty = specialtyMapper.map(specialtyRequestDto);
        Specialty savedSpecialty = specialtyRepository.save(specialty);
        return specialtyMapper.map(savedSpecialty);
    }

    public SpecialtyRequestDto updateSpecialty(Long id, SpecialtyRequestDto specialtyRequestDto){
        Optional<Specialty> specialty = specialtyRepository.findById(id);
        if(specialty.isPresent()){
            Specialty existentSpecialty = specialty.get();
            existentSpecialty.setName(specialtyRequestDto.getName());
            Specialty savedSpecialty = specialtyRepository.save(existentSpecialty);
            return specialtyMapper.map(savedSpecialty);
        }
        return null;
    }

    public void deleteSpecialty(Long id){
        Optional<Specialty> specialty = specialtyRepository.findById(id);
        if(specialty.isPresent()){
            specialtyRepository.delete(specialty.get());
        }
    }
    
}
