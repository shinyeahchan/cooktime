package com.side.cooktime.domain.userstorage.service;

import com.side.cooktime.domain.ingredient.model.Ingredient;
import com.side.cooktime.domain.ingredient.service.IngredientService;
import com.side.cooktime.domain.member.model.Member;
import com.side.cooktime.domain.member.service.MemberService;
import com.side.cooktime.domain.userstorage.model.UserStorage;
import com.side.cooktime.domain.userstorage.model.dto.request.RequestDeleteDto;
import com.side.cooktime.domain.userstorage.model.dto.request.RequestSaveDto;
import com.side.cooktime.domain.userstorage.repository.UserStorageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Service
public class UserStorageService {

    private final UserStorageRepository userStorageRepository;
    private final MemberService memberService;
    private final IngredientService ingredientService;

    public UserStorage delete(RequestDeleteDto requestDto) {
        UserStorage userStorage = userStorageRepository.findById(requestDto.getId()).orElse(null);
        userStorage.delete();
        return userStorage;
    }

    public List<UserStorage> saveAll(String memberEmail, List<RequestSaveDto> requestDtos) {
        Member member = memberService.findByEmail(memberEmail);
        if (member == null) { /*TODO:예외처리*/ }
        List<UserStorage> userStorages = requestDtos.stream()
                .map(requestDtoOne -> getUserStorage(member, requestDtoOne))
                .collect(Collectors.toList());
        return userStorageRepository.saveAll(userStorages);
    }

    private UserStorage getUserStorage(Member member, RequestSaveDto requestDtoOne) {
        Ingredient ingredient = ingredientService.findById(requestDtoOne.getIngredient_id());
        if (ingredient == null) { /*TODO:예외처리*/ }
        return requestDtoOne.toEntity(member, ingredient);
    }
}
