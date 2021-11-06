package com.example.predavanjademo.errors;

import com.example.predavanjademo.exceptions.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
// sloj koji hendluje greske
public class RestExceptionTranslator extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleValidationException(ValidationException validationException)
    {
        Errors errors = validationException.getErrors();
        List<FieldError> fieldErrors = errors.getFieldErrors();
        List<Map<String,Object>> customErrors = new ArrayList<>();

        for(FieldError fError : fieldErrors)
        {
            Map<String, Object> errorMap = new HashMap<>();
            errorMap.put("fieldName", fError.getField());
            errorMap.put("translationKey", fError.getCode());
            errorMap.put("message", fError.getDefaultMessage());
            errorMap.put("fieldValue", fError.getRejectedValue());

            customErrors.add(errorMap);
        }
        return new ResponseEntity<>(customErrors, HttpStatus.BAD_REQUEST);
    }
}
