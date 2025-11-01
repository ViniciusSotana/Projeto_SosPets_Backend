package dev.sospets.sosproject.SuccessStory;

import org.springframework.stereotype.Component;

@Component
public class SuccessStoryMapper {

    public SuccessStoryRequestDto map(SuccessStory successStory){

        SuccessStoryRequestDto successStoryRequestDto = new SuccessStoryRequestDto();
        successStoryRequestDto.setId(successStory.getId());
        successStoryRequestDto.setDate(successStory.getDate());
        successStoryRequestDto.setText(successStory.getText());
        successStoryRequestDto.setTitle(successStory.getTitle());
        successStoryRequestDto.setPetBreed(successStory.getPetBreed());
        successStoryRequestDto.setPetName(successStory.getPetName());

        return successStoryRequestDto;
    }

    public SuccessStory map(SuccessStoryRequestDto successStoryRequestDto){
        SuccessStory successStory = new SuccessStory();
        successStory.setId(successStoryRequestDto.getId());
        successStory.setTitle(successStoryRequestDto.getTitle());
        successStory.setText(successStoryRequestDto.getText());
        successStory.setDate(successStoryRequestDto.getDate());
        successStory.setPetBreed(successStoryRequestDto.getPetBreed());
        successStory.setPetName(successStoryRequestDto.getPetName());

        return successStory;
    }
}
