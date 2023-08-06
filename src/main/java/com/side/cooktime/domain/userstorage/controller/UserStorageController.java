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
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class UserStorageController {

    private final UserStorageService userStorageService;

    @PostMapping("/storage")
    public ResponseEntity<ResponseSaveDto> save(@RequestBody List<RequestSaveDto> requestDtos, Authentication authentication) {
        // 현재 인증된 사용자의 정보 가져오기
        DefaultOAuth2User oauth2User = (DefaultOAuth2User) authentication.getPrincipal();
        // oauth2User에서 이메일 정보 가져오기
        String member_email = oauth2User.getAttribute("email");
        List<UserStorage> savedUserStorages = userStorageService.saveAll(member_email, requestDtos);
        ResponseSaveDto responseDto = new ResponseSaveDto(member_email, savedUserStorages);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/storage")
    public ResponseEntity<ResponseDeleteDto> delete(@RequestBody RequestDeleteDto requestDto) {
        UserStorage userStorage = userStorageService.delete(requestDto);
        return new ResponseEntity<>(new ResponseDeleteDto(userStorage), HttpStatus.OK);
    }
}
