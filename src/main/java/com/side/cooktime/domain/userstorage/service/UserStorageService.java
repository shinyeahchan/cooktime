package com.side.cooktime.domain.userstorage.service;

import com.side.cooktime.domain.userstorage.repository.UserStorageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@RequiredArgsConstructor
@Service
public class UserStorageService {

    private final UserStorageRepository userStorageRepository;

}
