package com.tabula.drugs.utils.translator.utils;

import com.tabula.drugs.utils.translator.model.Language;

/**
 * @author Vladyslav_Vinnyk on 12/17/2016.
 */
public class CharacterUtils {
    private CharacterUtils() {
        throw new RuntimeException("Class not supposed to be instantiated");
    }

    public static Language evaluateCharacterLanguage(char character) {
        if (String.valueOf(character).matches("^[A-Za-z ]+$")) {
            return Language.ENG;
        }
        if (Character.UnicodeBlock.of(character).equals(Character.UnicodeBlock.CYRILLIC)) {
            return Language.RUS;
        }

        return Language.UNKNOWN;
    }
}
