package com.side.cooktime.domain.category.controller;


import com.side.cooktime.domain.category.model.Category;
import com.side.cooktime.domain.category.model.dto.request.RequestSaveDto;
import com.side.cooktime.domain.category.model.dto.response.ResponseDeleteDto;
import com.side.cooktime.domain.category.model.dto.response.ResponseSaveDto;
import com.side.cooktime.domain.category.service.CategoryService;
import com.side.cooktime.domain.ingredient.model.Name;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<ResponseSaveDto> save(@RequestBody RequestSaveDto requestDto) {
        Category category = categoryService.save(requestDto.toEntity());
        ResponseSaveDto responseDto = new ResponseSaveDto(category);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<ResponseDeleteDto> delete(@PathVariable("id") Long categoryId) {
        categoryService.delete(categoryId);
        return new ResponseEntity<>(new ResponseDeleteDto(categoryId), HttpStatus.OK);
    }
}
