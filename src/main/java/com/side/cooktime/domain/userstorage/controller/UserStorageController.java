package com.side.cooktime.domain.userstorage.controller;

import com.side.cooktime.domain.userstorage.model.UserStorage;
import com.side.cooktime.domain.userstorage.model.dto.request.RequestDeleteDto;
import com.side.cooktime.domain.userstorage.model.dto.request.RequestSaveDto;
import com.side.cooktime.domain.userstorage.model.dto.response.ResponseDeleteDto;
import com.side.cooktime.domain.userstorage.model.dto.response.ResponseSaveDto;
import com.side.cooktime.domain.userstorage.service.UserStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class UserStorageController {

    private final UserStorageService userStorageService;

    @PostMapping("/storage")
    public ResponseEntity<ResponseSaveDto> save(@RequestBody RequestSaveDto requestDto) {
        UserStorage userStorage = userStorageService.save(requestDto);

        if (userStorage == null) {
            //TODO: 예외처리
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        ResponseSaveDto responseDto = new ResponseSaveDto(userStorage);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/storage")
    public ResponseEntity<ResponseDeleteDto> delete(@RequestBody RequestDeleteDto requestDto) {
        UserStorage userStorage = userStorageService.delete(requestDto);
        return new ResponseEntity<>(new ResponseDeleteDto(userStorage), HttpStatus.OK);
    }
}
