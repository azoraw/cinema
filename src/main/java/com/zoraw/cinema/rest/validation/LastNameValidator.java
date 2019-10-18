package com.zoraw.cinema.rest.validation;

import com.zoraw.cinema.util.TextRules;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class LastNameValidator implements ConstraintValidator<LastName, String> {

    @Override
    public boolean isValid(String lastName, ConstraintValidatorContext context) {
        return areAllPartsOfLastNameValid(lastName);
    }

    private boolean areAllPartsOfLastNameValid(String lastName) {
        String[] surnameParts = lastName.split("-");
        return Arrays.stream(surnameParts)
                .allMatch(TextRules::isFirstLetterCapitalAndRestLower);
    }



}