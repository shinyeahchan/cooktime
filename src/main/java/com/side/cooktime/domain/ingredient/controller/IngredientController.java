package com.side.cooktime.domain.ingredient.controller;



import com.side.cooktime.domain.ingredient.model.dto.request.RequestSaveDto;
import com.side.cooktime.domain.ingredient.model.dto.response.ResponseDeleteDto;
import com.side.cooktime.domain.ingredient.model.dto.response.ResponseSaveDto;
import com.side.cooktime.domain.ingredient.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class IngredientController {

    private final IngredientService ingredientService;

//    @GetMapping("/ingredient")
//    public ResponseEntity<ResponseSaveDto> save(@RequestBody RequestSaveDto requestDto){
//        request
//
//    }
//
//    @DeleteMapping("/ingredient/{id}")
//    public ResponseEntity<ResponseDeleteDto> delete(@PathVariable("id") Long ingredientId){
//        return new ResponseEntity<>()
//    }

}
