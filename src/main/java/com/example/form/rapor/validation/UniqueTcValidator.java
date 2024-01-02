package com.example.form.rapor.validation;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.form.rapor.Rapor;
import com.example.form.rapor.RaporRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueTcValidator implements ConstraintValidator<UniqueTc, String> {

    @Autowired
    RaporRepository raporRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        Rapor inDb = raporRepository.findByHastaKimlik(value);
        return inDb == null;
    }

}
