package dev.sospets.sosproject.SuccessStory;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<SuccessStoryRequestDto> addSuccessStory(@RequestBody @Valid SuccessStoryRequestDto successStoryRequestDto) {
        SuccessStoryRequestDto createdSuccessStory = successStoryService.addSuccessStory(successStoryRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSuccessStory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessStoryRequestDto> updateSuccessStory(@PathVariable Long id, @RequestBody @Valid SuccessStoryRequestDto successStoryRequestDto) {
        SuccessStoryRequestDto updatedSuccessStory = successStoryService.updateSuccessStory(id, successStoryRequestDto);
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
