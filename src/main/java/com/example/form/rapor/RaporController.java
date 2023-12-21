package com.example.form.rapor;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.form.error.ApiError;
import com.example.form.rapor.dto.RaporCreate;
import com.example.form.rapor.dto.RaporDTO;
import com.example.form.shared.GenericMessage;

import jakarta.validation.Valid;

@RestController
public class RaporController {
    @Autowired
    RaporService raporService;

    @CrossOrigin
    @PostMapping("/api/v1/raporlar")
    GenericMessage createUser(@Valid @RequestBody RaporCreate raporCreate) {

        raporService.save(raporCreate.toRapor());
        return new GenericMessage("user created");
    }

    @CrossOrigin
    @GetMapping("/api/v1/raporlar")
    Page<RaporDTO> getRapors(Pageable page) {
        return raporService.getRapors(page).map(RaporDTO::new);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ApiError> handleMethodArgNotValidEx(MethodArgumentNotValidException exception) {
        ApiError apiError = new ApiError();
        apiError.setPath("/api/v1/raporlar");
        apiError.setMessage("Validation error");
        apiError.setStatus(400);

        var validationErrors = exception.getBindingResult().getFieldErrors().stream().collect(Collectors
                .toMap(FieldError::getField, FieldError::getDefaultMessage, (existing, replacing) -> existing));
        apiError.setValidationErrors(validationErrors);
        return ResponseEntity.badRequest().body(apiError);
    }
}
