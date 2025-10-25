package dev.sospets.sosproject.Category;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryRequestDto>> getCategory() {
        List<CategoryRequestDto> lCategories = categoryService.getAllCategories();
        return ResponseEntity.ok(lCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryRequestDto> getCategoryById(@PathVariable Long id) {
        CategoryRequestDto category = categoryService.getCategoryById(id);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CategoryRequestDto> addCategory(@RequestBody @Valid CategoryRequestDto categoryRequestDto) {
        CategoryRequestDto createdCategory = categoryService.addCategory(categoryRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryRequestDto> updateCategory(@PathVariable Long id, @RequestBody @Valid CategoryRequestDto categoryRequestDto) {
        CategoryRequestDto updatedCategory = categoryService.updateCategory(id, categoryRequestDto);
        if (updatedCategory != null) {
            return ResponseEntity.ok(updatedCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        if (categoryService.getCategoryById(id) != null) {
            categoryService.deleteCategory(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrado");
        }
    }


}
