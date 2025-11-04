package dev.sospets.sosproject.SuccessStory;

import org.springframework.stereotype.Component;

@Component
public class SuccessStoryMapper {

    public SuccessStoryRequestDto map(SuccessStory successStory){

        SuccessStoryRequestDto successStoryRequestDto = new SuccessStoryRequestDto();
        successStoryRequestDto.setId(successStory.getId());
        successStoryRequestDto.setDate(successStory.getDate());
        successStoryRequestDto.setText(successStory.getText());
        successStoryRequestDto.setOwnerName(successStory.getOwnerName());
        successStoryRequestDto.setPetBreed(successStory.getPetBreed());
        successStoryRequestDto.setPetName(successStory.getPetName());

        return successStoryRequestDto;
    }

    public SuccessStory map(SuccessStoryRequestDto successStoryRequestDto){
        SuccessStory successStory = new SuccessStory();
        successStory.setId(successStoryRequestDto.getId());
        successStory.setText(successStoryRequestDto.getText());
        successStory.setDate(successStoryRequestDto.getDate());
        successStory.setPetBreed(successStoryRequestDto.getPetBreed());
        successStory.setPetName(successStoryRequestDto.getPetName());
        successStory.setOwnerName(successStoryRequestDto.getOwnerName());

        return successStory;
    }
}
