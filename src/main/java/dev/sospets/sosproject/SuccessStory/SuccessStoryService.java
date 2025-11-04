package dev.sospets.sosproject.SuccessStory;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SuccessStoryService {

    private final SuccessStoryRepository successStoryRepository;
    private final SuccessStoryMapper successStoryMapper;

    public SuccessStoryService(SuccessStoryRepository successStoryRepository, SuccessStoryMapper successStoryMapper) {
        this.successStoryRepository = successStoryRepository;
        this.successStoryMapper = successStoryMapper;
    }


    public List<SuccessStoryRequestDto> getAllSuccessStories() {
        List<SuccessStory> lSuccessStories = successStoryRepository.findAll();
        return lSuccessStories.stream()
                .map(successStoryMapper::map)
                .collect(Collectors.toList());
    }

    public SuccessStoryRequestDto getSuccessStoryById(Long id){
        Optional<SuccessStory> successStory = successStoryRepository.findById(id);
        return successStory.map(successStoryMapper::map).orElse(null);
    }

    public SuccessStoryRequestDto addSuccessStory(SuccessStoryRequestDto successStoryRequestDto){
        SuccessStory successStory = successStoryMapper.map(successStoryRequestDto);
        SuccessStory savedSuccessStory = successStoryRepository.save(successStory);
        return successStoryMapper.map(savedSuccessStory);
    }

    public SuccessStoryRequestDto updateSuccessStory(Long id, SuccessStoryRequestDto successStoryRequestDto){
        Optional<SuccessStory> successStory = successStoryRepository.findById(id);
        if(successStory.isPresent()){
            SuccessStory existentSuccessStory = successStory.get();

            existentSuccessStory.setId(successStoryRequestDto.getId());
            existentSuccessStory.setDate(successStoryRequestDto.getDate());
            existentSuccessStory.setText(successStoryRequestDto.getText());
            existentSuccessStory.setTitle(successStoryRequestDto.getTitle());
            existentSuccessStory.setPetBreed(successStoryRequestDto.getPetBreed());
            existentSuccessStory.setPetName(successStoryRequestDto.getPetName());
            existentSuccessStory.setOwnerName(successStoryRequestDto.getOwnerName());

            SuccessStory savedSuccessStory = successStoryRepository.save(existentSuccessStory);
            return successStoryMapper.map(savedSuccessStory);
        }
        return null;
    }

    public void deleteSuccessStory(Long id){
        Optional<SuccessStory> successStory = successStoryRepository.findById(id);
        if(successStory.isPresent()){
            successStoryRepository.delete(successStory.get());
        }
    }
    
}
