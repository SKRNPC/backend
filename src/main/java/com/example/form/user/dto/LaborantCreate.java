package com.example.form.user.dto;

import com.example.form.user.Laborant;
import com.example.form.user.validation.UniqueKimlik;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LaborantCreate(

                @NotBlank String isim,
                @Size(min = 7, max = 7) @UniqueKimlik String labKimlik) {

        public Laborant toLaborant() {
                Laborant laborant = new Laborant();
                laborant.setIsim(isim);
                laborant.setLabKimlik(labKimlik);
                return laborant;
        }

}
