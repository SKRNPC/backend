package com.example.form.rapor.validation;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.form.file.FileService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FileTypeValidator implements ConstraintValidator<FileType, String>{

    @Autowired
    FileService fileService;
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null || value.isEmpty()) return true;
        try {
            String type = fileService.detectType(value);
            return type.equals("image/jpeg") || type.equals("image/png");
        } catch (Exception e) {
            // Log or handle the exception as needed
            e.printStackTrace();
            return false;
        }
    }
}
