package com.side.cooktime.domain.userstorage.service;

import com.side.cooktime.domain.ingredient.model.Ingredient;
import com.side.cooktime.domain.ingredient.service.IngredientService;
import com.side.cooktime.domain.member.model.Member;
import com.side.cooktime.domain.member.service.MemberService;
import com.side.cooktime.domain.userstorage.model.UserStorage;
import com.side.cooktime.domain.userstorage.model.dto.request.RequestSaveDto;
import com.side.cooktime.domain.userstorage.repository.UserStorageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@RequiredArgsConstructor
@Service
public class UserStorageService {

    private final UserStorageRepository userStorageRepository;
    private final MemberService memberService;
    private final IngredientService ingredientService;

    public boolean save(RequestSaveDto requestDto) {
        Member member = memberService.findByEmail(requestDto.getMember_email());
        Ingredient ingredient = ingredientService.findById(requestDto.getIngredient_id());
        UserStorage userStorage = requestDto.toEntity(member, ingredient);
        userStorageRepository.save(userStorage);
        return true;
    }
}
