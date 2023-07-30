package com.side.cooktime.domain.userstorage.repository;

import com.side.cooktime.domain.userstorage.model.UserStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStorageRepository extends JpaRepository<UserStorage, Long> {

}
