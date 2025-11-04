package dev.sospets.sosproject.Category;

import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category map(CategoryRequestDto categoryRequestDto) {
        Category category = new Category();
        category.setId(categoryRequestDto.getId());
        category.setName(categoryRequestDto.getName());
        return category;
    }

    public CategoryRequestDto map(Category category) {
        CategoryRequestDto categoryRequestDto = new CategoryRequestDto();
        categoryRequestDto.setId(category.getId());
        categoryRequestDto.setName(category.getName());
        return categoryRequestDto;
    }

}
