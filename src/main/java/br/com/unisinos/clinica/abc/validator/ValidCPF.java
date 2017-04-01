package br.com.unisinos.clinica.abc.validator;


import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = CPFValidator.class)
public @interface ValidCPF {

    String message() default "{violation.invalid.cpf}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
