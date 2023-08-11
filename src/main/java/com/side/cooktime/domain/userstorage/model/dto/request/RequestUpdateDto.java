package com.side.cooktime.domain.userstorage.model.dto.request;

import com.side.cooktime.domain.ingredient.model.Ingredient;
import com.side.cooktime.domain.member.model.Member;
import com.side.cooktime.domain.userstorage.model.UserStorage;
import lombok.Data;

import java.util.List;
import java.util.stream.IntStream;

@Data
public class RequestUpdateDto {
    private List<RequestUpdateOneDto> request;

    public List<UserStorage> toEntities(Member member, List<Ingredient> ingredients) {
        return IntStream.range(0, request.size())
                .mapToObj(index -> getUserStorage(request.get(index), member, ingredients.get(index)))
                .toList();
    }

    private UserStorage getUserStorage(RequestUpdateOneDto requestOneDto, Member member, Ingredient ingredient) {
        return requestOneDto.toEntity(member, ingredient);
    }
}
