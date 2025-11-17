package dev.sospets.sosproject.SuccessStory;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/successStories")
public class SuccessStoryController {

    private final SuccessStoryService successStoryService;

    public SuccessStoryController(SuccessStoryService successStoryService) {
        this.successStoryService = successStoryService;
    }

    @GetMapping
    public ResponseEntity<List<SuccessStoryRequestDto>> getSuccessStories() {
        List<SuccessStoryRequestDto> lSuccessStories = successStoryService.getAllSuccessStories();
        return ResponseEntity.ok(lSuccessStories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessStoryRequestDto> getSuccessStoryById(@PathVariable Long id) {
        SuccessStoryRequestDto successStory = successStoryService.getSuccessStoryById(id);
        if (successStory != null) {
            return ResponseEntity.ok(successStory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public SuccessStoryRequestDto addSuccessStory(
            @RequestPart("story") @Parameter(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)) @Valid SuccessStoryRequestDto storyDto,
            @RequestPart(value = "files", required = false) List<MultipartFile> files) {

        return successStoryService.addSuccessStory(storyDto, files);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<SuccessStoryRequestDto> updateSuccessStory(
            @PathVariable Long id,
            @RequestPart("story") @Parameter(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)) @Valid SuccessStoryRequestDto successStoryRequestDto,
            @RequestPart(value = "files", required = false) List<MultipartFile> files) {

        SuccessStoryRequestDto updatedSuccessStory = successStoryService.updateSuccessStory(id, successStoryRequestDto, files);

        if (updatedSuccessStory != null) {
            return ResponseEntity.ok(updatedSuccessStory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSuccessStory(@PathVariable Long id) {
        if (successStoryService.getSuccessStoryById(id) != null) {
            successStoryService.deleteSuccessStory(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Success Story não encontrado");
        }
    }
    
}
