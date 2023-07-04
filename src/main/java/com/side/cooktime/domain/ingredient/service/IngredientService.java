package com.side.cooktime.domain.ingredient.service;

import com.side.cooktime.domain.ingredient.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;
}
