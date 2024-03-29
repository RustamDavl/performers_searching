package com.rustdv.webconstruction.validation.annotation;

import com.rustdv.webconstruction.validation.group.CreateGroup;
import com.rustdv.webconstruction.validation.validator.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Email;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {PasswordValidator.class})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface ValidPassword {
    String message() default "password must be filled in";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
