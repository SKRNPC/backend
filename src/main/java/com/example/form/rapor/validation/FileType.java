package com.example.form.rapor.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = FileTypeValidator.class)
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FileType {
     String message() default "Sadece jpeg ve png dosyaları yükleyiniz.";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
    
}
