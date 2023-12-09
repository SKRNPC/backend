package com.example.form.user.validation;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.form.user.Laborant;
import com.example.form.user.UserRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueKimlikValidator implements ConstraintValidator<UniqueKimlik, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        Laborant inDb = userRepository.findByLabKimlik(value);
        return inDb == null;
    }

}
