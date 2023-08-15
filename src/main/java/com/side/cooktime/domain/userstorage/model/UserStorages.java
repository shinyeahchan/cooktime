package com.side.cooktime.domain.userstorage.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class UserStorages {
    private List<UserStorage> userStorages = new ArrayList<>();

    public UserStorages(List<UserStorage> list){
        userStorages = list;
    }

    public int getSize(){
        return this.userStorages.size();
    }

    public <T> List<T> toDtos(Function<UserStorage, T> mapper){
        return userStorages.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }
}
