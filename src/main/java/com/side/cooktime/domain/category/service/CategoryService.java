package com.side.cooktime.domain.category.service;

import com.side.cooktime.domain.category.model.Category;
import com.side.cooktime.domain.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category findById(Long id){
        return categoryRepository.findById(id).orElse(null);
    }

    public void delete(Long categoryId){
        categoryRepository.deleteById(categoryId);
    }
}
