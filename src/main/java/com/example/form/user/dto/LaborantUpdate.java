package com.example.form.user.dto;



import jakarta.validation.constraints.NotBlank;

public record LaborantUpdate(
        @NotBlank String isim

) {
    
}
