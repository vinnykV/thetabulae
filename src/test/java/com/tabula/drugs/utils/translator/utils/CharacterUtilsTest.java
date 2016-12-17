package com.tabula.drugs.utils.translator.utils;

import com.tabula.drugs.utils.translator.model.Language;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Vladyslav_Vinnyk on 12/17/2016.
 */
public class CharacterUtilsTest {

    @Test
    public void shouldEvaluateToEng() {
        String engAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ";
        Language expected = Language.ENG;

        for (char charToTest: engAlphabet.toCharArray()) {
            Language actual = CharacterUtils.evaluateCharacterLanguage(charToTest);
            Assert.assertTrue(expected == actual);
        }
    }

    @Test
    public void shouldEvaluateToRus() {
        String engAlphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        Language expected = Language.RUS;

        for (char charToTest: engAlphabet.toCharArray()) {
            Language actual = CharacterUtils.evaluateCharacterLanguage(charToTest);
            Assert.assertTrue(expected == actual);
        }
    }
}