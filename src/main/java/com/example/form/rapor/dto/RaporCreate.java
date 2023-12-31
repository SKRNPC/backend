package com.example.form.rapor.dto;

import com.example.form.rapor.Rapor;
import com.example.form.rapor.validation.FileType;
import com.example.form.rapor.validation.UniqueTc;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RaporCreate(

        @Size(min = 5, max = 5) String dosyaNo,

        @NotBlank String selectedLaborant,

        @NotBlank String hastaIsim,
        @Size(min = 11, max = 11) @UniqueTc String hastaKimlik,

        @NotBlank String hastaTani,

        String taniDetay,

        @NotBlank String selectedDate,

        @FileType String selectedFile)

{

    public Rapor toRapor() {
        Rapor rapor = new Rapor();
        rapor.setSelectedLaborant(selectedLaborant);
        rapor.setDosyaNo(dosyaNo);
        rapor.setHastaIsim(hastaIsim);
        rapor.setHastaKimlik(hastaKimlik);
        rapor.setHastaTani(hastaTani);
        rapor.setTaniDetay(taniDetay);
        rapor.setSelectedDate(selectedDate);
        rapor.setSelectedFile(selectedFile);
        return rapor;
    }
}
