package com.example.form.rapor.dto;



import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RaporUpdate(
        @Size(min = 5, max = 5) String dosyaNo,

        @NotBlank String selectedLaborant,

        @NotBlank String hastaIsim,
        @Size(min = 11, max = 11) String hastaKimlik,

        @NotBlank String hastaTani,

        String taniDetay,
        
        String selectedDate,

        @Lob String selectedFile) {

}
