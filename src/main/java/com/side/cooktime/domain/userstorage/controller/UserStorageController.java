package com.side.cooktime.domain.userstorage.controller;

import com.side.cooktime.config.auth.OAuth2UserUtils;
import com.side.cooktime.domain.userstorage.model.dto.request.RequestDeleteDto;
import com.side.cooktime.domain.userstorage.model.dto.request.RequestSaveDto;
import com.side.cooktime.domain.userstorage.model.dto.request.RequestUpdateDto;
import com.side.cooktime.domain.userstorage.model.dto.response.*;
import com.side.cooktime.domain.userstorage.service.UserStorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
@Log4j2
public class UserStorageController {

    private final UserStorageService userStorageService;

    @PostMapping("/storage")
    public ResponseEntity<ResponseSaveDto> save(@RequestBody RequestSaveDto requestDto, Authentication authentication) {
        ResponseSaveDto responseSaveDto = userStorageService.save(OAuth2UserUtils.getEmail(authentication), requestDto);
        return new ResponseEntity<>(responseSaveDto, HttpStatus.CREATED);
    }

    @PutMapping("/storage")
    public ResponseEntity<ResponseUpdateDto> update(@RequestBody RequestUpdateDto requestDto, Authentication authentication) {
        ResponseUpdateDto responseDto = userStorageService.update(OAuth2UserUtils.getEmail(authentication), requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/storage/delete")
    public ResponseEntity<ResponseDeleteDto> delete(@RequestBody RequestDeleteDto requestDto, Authentication authentication) {
        ResponseDeleteDto responseDto = userStorageService.delete(OAuth2UserUtils.getEmail(authentication), requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/storage/all")
    public ResponseEntity<ResponseGetDto> get(Authentication authentication) {
        ResponseGetDto responseDto = userStorageService.get(OAuth2UserUtils.getEmail(authentication));
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    //TODO: get (with 페이징)

}
