package dev.sospets.sosproject.Category;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }


    public List<CategoryRequestDto> getAllCategories() {
        List<Category> lCategory = categoryRepository.findAll();
        return lCategory.stream()
                .map(categoryMapper::map)
                .collect(Collectors.toList());
    }

    public CategoryRequestDto getCategoryById(Long id){
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(categoryMapper::map).orElse(null);
    }

    public CategoryRequestDto addCategory(CategoryRequestDto categoryRequestDto){
        Category category = categoryMapper.map(categoryRequestDto);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.map(savedCategory);
    }

    public CategoryRequestDto updateCategory(Long id, CategoryRequestDto categoryRequestDto){
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()){
            Category existentCategory = category.get();
            existentCategory.setName(categoryRequestDto.getName());
            Category savedCategory = categoryRepository.save(existentCategory);
            return categoryMapper.map(savedCategory);
        }
        return null;
    }

    public void deleteCategory(Long id){
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()){
            categoryRepository.delete(category.get());
        }
    }

}
