package com.beyzaslan.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

//amac spring validationdan fırlatılan hataları yönetmek ve response dönmek

@ControllerAdvice
public class GlobalExceptionHandler {
    private List<String> addMapValue(List<String> list, String newValue) {
        list.add(newValue);
        return list;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, List<String>> errorsMap = new HashMap<>();
        for (ObjectError objError : ex.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError) objError).getField();
            if (errorsMap.containsKey(fieldName)) {
                errorsMap.put(fieldName, addMapValue(errorsMap.get(fieldName), objError.getDefaultMessage()));

            } else {
                errorsMap.put(fieldName, addMapValue(new ArrayList<>(), objError.getDefaultMessage()));

            }
        }
        return ResponseEntity.badRequest().body(createError(errorsMap));

    }

    private <T> ApiError<T> createError(T errors) {
        ApiError<T> apiErrror = new ApiError<T>();
        apiErrror.setId(UUID.randomUUID().toString());
        apiErrror.setErrorTime(new Date());
        apiErrror.setErrors(errors);
        return apiErrror;
    }
}























