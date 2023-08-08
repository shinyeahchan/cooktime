package com.side.cooktime.domain.userstorage.service;

import com.side.cooktime.domain.category.model.Category;
import com.side.cooktime.domain.category.service.CategoryService;
import com.side.cooktime.domain.ingredient.model.Ingredient;
import com.side.cooktime.domain.ingredient.model.dto.request.RequestSaveDto;
import com.side.cooktime.domain.ingredient.service.IngredientService;
import com.side.cooktime.domain.member.service.MemberService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

@SpringBootTest
@Transactional
class UserStorageServiceTest {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        Category category = new Category("소고기");
        categoryService.save(category);

        RequestSaveDto saveDto = new RequestSaveDto();
        saveDto.setCategoryId(1L);
        saveDto.setName("뒷다리살");
        saveDto.setUrl("test");
        saveDto.setExpirationPeriod(30);
        saveDto.setStorage("COLD");
        saveDto.setCountType("COUNT");
        ingredientService.save(saveDto);

        RequestSaveDto saveDto2 = new RequestSaveDto();
        saveDto2.setCategoryId(1L);
        saveDto2.setName("앞다리살");
        saveDto2.setUrl("test");
        saveDto2.setExpirationPeriod(15);
        saveDto2.setStorage("ROOM");
        saveDto2.setCountType("COUNT");
        ingredientService.save(saveDto2);

        entityManager.clear();
    }

    @Test
    void getReferenceById() {
        ingredientService.getReferenceById(1L);
    }

    @Test
    void getReferenceById1() {
        Ingredient ingredient = ingredientService.getReferenceById(1L);
        System.out.println(ingredient.getName().getName());
    }

    @Test
    void getReferenceById2() {
        Ingredient ingredient = ingredientService.getReferenceById(77L);
    }

    @Test
    void getReferenceById3() {
        Ingredient ingredient = ingredientService.getReferenceById(77L);
        System.out.println(ingredient.getName().getName());
    }
}
