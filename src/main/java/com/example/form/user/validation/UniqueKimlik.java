package com.example.form.user.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = UniqueKimlikValidator.class)
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueKimlik {
    String message() default "Kimlik No kullanılıyor";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
    
}
