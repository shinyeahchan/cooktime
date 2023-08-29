package com.side.cooktime.global.exception;

import com.side.cooktime.domain.category.exception.CategoryException;
import com.side.cooktime.domain.ingredient.exception.IngredientException;
import com.side.cooktime.domain.member.exception.MemberException;
import com.side.cooktime.domain.userstorage.exception.UserStorageException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserStorageException.class)
    protected ResponseEntity<ErrorResponseEntity> handleMethodArgumentNotValidException(UserStorageException ex) {
        return ErrorResponseEntity.toResponseEntity(ex.getErrorCode());
    }

    @ExceptionHandler(CategoryException.class)
    protected ResponseEntity<ErrorResponseEntity> handleCategoryException(CategoryException ex) {
        log.info("CateogryException 테스트");
        return ErrorResponseEntity.toResponseEntity(ex.getErrorCode());
    }

    @ExceptionHandler(IngredientException.class)
    protected ResponseEntity<ErrorResponseEntity> handleIngredientException(IngredientException ex) {
        log.info("CateogryException 테스트");
        return ErrorResponseEntity.toResponseEntity(ex.getErrorCode());
    }

    @ExceptionHandler(MemberException.class)
    protected ResponseEntity<ErrorResponseEntity> handleMemberException(MemberException ex) {
        log.info("CateogryException 테스트");
        return ErrorResponseEntity.toResponseEntity(ex.getErrorCode());
    }


}
