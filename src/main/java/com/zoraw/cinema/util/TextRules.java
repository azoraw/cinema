package com.zoraw.cinema.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TextRules {

    public static boolean isFirstLetterCapitalAndRestLower(String text) {
        return Character.isUpperCase(text.charAt(0))
                && text.trim()
                .substring(1)
                .chars()
                .allMatch(Character::isLowerCase);
    }
}
