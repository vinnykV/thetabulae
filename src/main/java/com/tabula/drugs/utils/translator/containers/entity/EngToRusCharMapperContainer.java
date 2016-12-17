package com.tabula.drugs.utils.translator.containers.entity;

import com.tabula.drugs.utils.asserter.Assert;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Vladyslav_Vinnyk on 12/15/2016.
 */
public class EngToRusCharMapperContainer {
    public static final Map<String, String> ENG_TO_RUS;

    static {
        Map<String, String> temporalEnglishToRusMap = new HashMap<>();
        temporalEnglishToRusMap.put("a", "а");
        temporalEnglishToRusMap.put("b", "б");
        temporalEnglishToRusMap.put("c", "к");
        temporalEnglishToRusMap.put("d", "д");
        temporalEnglishToRusMap.put("e", "е");
        temporalEnglishToRusMap.put("f", "ф");
        temporalEnglishToRusMap.put("g", "г");
        temporalEnglishToRusMap.put("h", "г");
        temporalEnglishToRusMap.put("i", "и");
        temporalEnglishToRusMap.put("j", "");
        temporalEnglishToRusMap.put("k", "к");
        temporalEnglishToRusMap.put("l", "л");
        temporalEnglishToRusMap.put("m", "м");
        temporalEnglishToRusMap.put("n", "н");
        temporalEnglishToRusMap.put("o", "о");
        temporalEnglishToRusMap.put("p", "п");
        temporalEnglishToRusMap.put("q", "кв");
        temporalEnglishToRusMap.put("r", "р");
        temporalEnglishToRusMap.put("s", "с");
        temporalEnglishToRusMap.put("t", "т");
        temporalEnglishToRusMap.put("u", "у");
        temporalEnglishToRusMap.put("v", "в");
        temporalEnglishToRusMap.put("w", "в");
        temporalEnglishToRusMap.put("x", "кс");
        temporalEnglishToRusMap.put("y", "и");
        temporalEnglishToRusMap.put("z", "з");
        temporalEnglishToRusMap.put(" ", " ");
        temporalEnglishToRusMap.putAll(getReverse(temporalEnglishToRusMap));

        ENG_TO_RUS = Collections.unmodifiableMap(temporalEnglishToRusMap);
    }

    public static Map<String, String> getReverse(Map<String, String> temporalEnglishToRusMap) {
        Map<String, String> reversedMap = new HashMap<>();

        for (Map.Entry<String, String> entry : temporalEnglishToRusMap.entrySet()) {
            reversedMap.put(entry.getValue(), entry.getKey());
        }

        return reversedMap;
    }

    public static String convertToRus(String engCharacter) {
        Assert.assertMapContains(engCharacter, ENG_TO_RUS);
        return ENG_TO_RUS.get(engCharacter);
    }

}