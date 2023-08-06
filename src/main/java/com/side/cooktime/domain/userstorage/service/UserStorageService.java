package com.side.cooktime.domain.userstorage.service;

import com.side.cooktime.domain.ingredient.model.Ingredient;
import com.side.cooktime.domain.ingredient.service.IngredientService;
import com.side.cooktime.domain.member.model.Member;
import com.side.cooktime.domain.member.service.MemberService;
import com.side.cooktime.domain.userstorage.model.UserStorage;
import com.side.cooktime.domain.userstorage.model.dto.request.RequestDeleteDto;
import com.side.cooktime.domain.userstorage.model.dto.request.RequestSaveDto;
import com.side.cooktime.domain.userstorage.model.dto.response.ResponseDeleteDto;
import com.side.cooktime.domain.userstorage.model.dto.response.ResponseSaveDto;
import com.side.cooktime.domain.userstorage.repository.UserStorageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class UserStorageService {

    private final UserStorageRepository userStorageRepository;
    private final MemberService memberService;
    private final IngredientService ingredientService;

    public ResponseSaveDto saveAll(String memberEmail, List<RequestSaveDto> requestDtos) {
        Member member = memberService.findByEmail(memberEmail);
        if (member == null) { /*TODO:예외처리*/ }
        List<UserStorage> userStorages = requestDtos.stream()
                .map(requestDtoOne -> getUserStorage(member, requestDtoOne))
                .toList();
        List<UserStorage> savedUserStorages = userStorageRepository.saveAll(userStorages);
        return new ResponseSaveDto(memberEmail, savedUserStorages);
    }

    private UserStorage getUserStorage(Member member, RequestSaveDto requestDtoOne) {
        Ingredient ingredient = ingredientService.findById(requestDtoOne.getIngredient_id());
        if (ingredient == null) { /*TODO:예외처리*/ }
        return requestDtoOne.toEntity(member, ingredient);
    }

    public ResponseDeleteDto deleteAllSoftly(String memberEmail, List<RequestDeleteDto> requestDtos) {
        Member member = memberService.findByEmail(memberEmail);
        List<Long> deleteRequestedIds = requestDtos.stream().map(RequestDeleteDto::getId).toList();
        List<UserStorage> userStorages = userStorageRepository.findByIdInAndMember(deleteRequestedIds, member);
        for (UserStorage userStorage : userStorages) {
            userStorage.delete();
        }
        return new ResponseDeleteDto(memberEmail, userStorages);
    }
}
