package com.zoraw.cinema.rest.validation;

import com.zoraw.cinema.util.TextRules;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<Name, String> {

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return TextRules.isFirstLetterCapitalAndRestLower(name);
    }

}