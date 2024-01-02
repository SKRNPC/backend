package com.example.form.rapor.dto;

import com.example.form.rapor.validation.FileType;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RaporUpdate(
                @Size(min = 5, max = 5) String dosyaNo,

                @NotBlank String selectedLaborant,

                @NotBlank String hastaIsim,

                @NotBlank String hastaTani,

                String taniDetay,
                
                @NotBlank String selectedDate,

                @FileType
                String selectedFile) {

}
