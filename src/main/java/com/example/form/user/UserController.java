package com.example.form.user;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.form.error.ApiError;
import com.example.form.shared.GenericMessage;

import jakarta.validation.Valid;

@RestController
public class UserController {

    @Autowired
    LaborantService laborantService;

    @CrossOrigin
    @PostMapping("/api/v1/laborants")
    GenericMessage createLaborant(@Valid @RequestBody Laborant laborant) {
        laborantService.save(laborant);
        return new GenericMessage("User is created");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ApiError> handleMethodArgNotValidEx(MethodArgumentNotValidException exception) {
        ApiError apiError = new ApiError();
        apiError.setPath("/api/v1/laborants");
        apiError.setMessage("Validation error");
        apiError.setStatus(400);

        var validationErrors = exception.getBindingResult().getFieldErrors().stream().collect(Collectors
                .toMap(FieldError::getField, FieldError::getDefaultMessage, (existing, replacing) -> existing));
        apiError.setValidationErrors(validationErrors);
        return ResponseEntity.badRequest().body(apiError);
    }
     @ExceptionHandler(NotUniqueKimlikException.class)
    ResponseEntity<ApiError> handleNotUniqueKimlikEx( NotUniqueKimlikException exception) {
        ApiError apiError = new ApiError();
        apiError.setPath("/api/v1/laborants");
        apiError.setMessage("Validation error");
        apiError.setStatus(400);
        Map<String, String> validationErrors = new HashMap<>();
        validationErrors.put("labKimlik","Bu Kimlik No kullanılıyor");
        apiError.setValidationErrors(validationErrors);
        return ResponseEntity.badRequest().body(apiError);
    }
}