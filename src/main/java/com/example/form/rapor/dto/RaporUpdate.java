package com.example.form.rapor.dto;

import com.example.form.rapor.validation.FileType;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RaporUpdate(
                @Size(min = 5, max = 5) String dosyaNo,

                @NotBlank String selectedLaborant,

                @NotBlank String hastaIsim,
                @Size(min = 11, max = 11) String hastaKimlik,

                @NotBlank String hastaTani,

                String taniDetay,
                
                @NotBlank String selectedDate,

                @FileType
                String selectedFile) {

}
