package com.example.form.user;

import java.util.HashMap;
import java.util.Map;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.form.error.ApiError;
import com.example.form.shared.GenericMessage;
import com.example.form.user.dto.LaborantCreate;
import com.example.form.user.dto.LaborantUpdate;
import com.example.form.user.dto.LaborantDTO;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@RestController
public class LaborantController {

    @Autowired
    LaborantService laborantService;

    @CrossOrigin
    @PostMapping("/api/v1/laborants")
    GenericMessage createLaborant(@Valid @RequestBody LaborantCreate laborant) {
        laborantService.save(laborant.toLaborant());
        return new GenericMessage("User is created");
    }

    @CrossOrigin
    @GetMapping("/api/v1/laborants")
    Page<LaborantDTO> getLaborants(Pageable page) {
        return laborantService.getLaborants(page).map(LaborantDTO::new);
    }

    @CrossOrigin
    @GetMapping("/api/v1/laborants/{id}")
    public LaborantDTO getLaborant(@PathVariable long id) {
        return new LaborantDTO(laborantService.getLaborant(id));
    }

    @CrossOrigin
    @PutMapping("/api/v1/laborants/{id}")
    public LaborantDTO updateLaborant(@PathVariable long id, @Valid @RequestBody LaborantUpdate laborantUpdate) {

        return new LaborantDTO(laborantService.updateLaborant(id, laborantUpdate));
    }

    @CrossOrigin
    @DeleteMapping("/api/v1/laborants/{id}")
    GenericMessage deleteLaborant(@PathVariable long id) {
        laborantService.deleteLaborant(id);
        return new GenericMessage("Laborant is deleted");
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
    ResponseEntity<ApiError> handleNotUniqueKimlikEx(NotUniqueKimlikException exception) {
        ApiError apiError = new ApiError();
        apiError.setPath("/api/v1/laborants");
        apiError.setMessage("Validation error");
        apiError.setStatus(400);
        Map<String, String> validationErrors = new HashMap<>();
        validationErrors.put("labKimlik", "Bu Kimlik No kullanılıyor");
        apiError.setValidationErrors(validationErrors);
        return ResponseEntity.badRequest().body(apiError);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    ResponseEntity<ApiError> handleEntityNotFoundExcepiton(EntityNotFoundException exception) {
        ApiError apiError = new ApiError();
        apiError.setPath("/api/v1/laborants");
        apiError.setMessage("Not Found");
        apiError.setStatus(404);
        return ResponseEntity.badRequest().body(apiError);
    }
}
