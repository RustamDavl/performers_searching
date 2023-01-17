package com.rustdv.webconstruction.validation.annotation;

import com.rustdv.webconstruction.validation.validator.PasswordValidator;
import com.rustdv.webconstruction.validation.validator.RoleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {RoleValidator.class})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface ValidRole{
    String message() default "the role must be EXECUTOR or CUSTOMER";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}