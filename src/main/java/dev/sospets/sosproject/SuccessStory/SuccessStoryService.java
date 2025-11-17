package dev.sospets.sosproject.SuccessStory;

import dev.sospets.sosproject.Image.Image;
import dev.sospets.sosproject.config.Cloudinary.CloudinaryService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SuccessStoryService {

    private final SuccessStoryRepository successStoryRepository;
    private final SuccessStoryMapper successStoryMapper;
    private final CloudinaryService cloudinaryService;

    public SuccessStoryService(SuccessStoryRepository successStoryRepository, SuccessStoryMapper successStoryMapper, CloudinaryService cloudinaryService) {
        this.successStoryRepository = successStoryRepository;
        this.successStoryMapper = successStoryMapper;
        this.cloudinaryService = cloudinaryService;
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

    public SuccessStoryRequestDto addSuccessStory(SuccessStoryRequestDto successStoryRequestDto, List<MultipartFile> files) {

        SuccessStory successStory = successStoryMapper.map(successStoryRequestDto);

        if (files != null && !files.isEmpty()) {
            List<Image> imagesList = new ArrayList<>();
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    String url = cloudinaryService.uploadFile(file);
                    Image image = new Image();
                    image.setPath(url);
                    image.setSuccessStory(successStory);
                    imagesList.add(image);
                }
            }
            successStory.setImages(imagesList);
        }

        SuccessStory savedSuccessStory = successStoryRepository.save(successStory);
        return successStoryMapper.map(savedSuccessStory);
    }

    public SuccessStoryRequestDto updateSuccessStory(Long id, SuccessStoryRequestDto successStoryRequestDto, List<MultipartFile> files) {
        SuccessStory existentSuccessStory = successStoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Success Story com id " + id + " não encontrada"));

        existentSuccessStory.setDate(successStoryRequestDto.getDate());
        existentSuccessStory.setText(successStoryRequestDto.getText());
        existentSuccessStory.setPetBreed(successStoryRequestDto.getPetBreed());
        existentSuccessStory.setPetName(successStoryRequestDto.getPetName());
        existentSuccessStory.setOwnerName(successStoryRequestDto.getOwnerName());

        if (files != null && !files.isEmpty()) {
            List<Image> imagesList = new ArrayList<>();
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    String url = cloudinaryService.uploadFile(file);
                    Image image = new Image();
                    image.setPath(url);
                    image.setSuccessStory(existentSuccessStory);
                    imagesList.add(image);
                }
            }
            existentSuccessStory.setImages(imagesList);
        }

        SuccessStory savedSuccessStory = successStoryRepository.save(existentSuccessStory);
        return successStoryMapper.map(savedSuccessStory);
    }

    public void deleteSuccessStory(Long id){
        Optional<SuccessStory> successStory = successStoryRepository.findById(id);
        if(successStory.isPresent()){
            successStoryRepository.delete(successStory.get());
        }
    }
    
}
