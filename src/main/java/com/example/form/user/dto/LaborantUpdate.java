package com.example.form.user.dto;


import com.example.form.user.validation.UniqueKimlik;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LaborantUpdate(
        @NotBlank String isim,
        @Size(min = 7, max = 7) @UniqueKimlik String labKimlik

) {
    
}
