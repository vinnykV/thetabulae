package com.tabula.drugs.utils.translator.impl;

import com.tabula.drugs.utils.ConstantsContainer;
import com.tabula.drugs.utils.translator.RuleEvaluator;
import com.tabula.drugs.utils.translator.api.Transliterator;
import com.tabula.drugs.utils.translator.containers.api.ConvertingRulesManager;
import com.tabula.drugs.utils.translator.containers.entity.EngToRusCharMapperContainer;
import com.tabula.drugs.utils.translator.model.ConvertingRule;
import org.apache.commons.lang3.mutable.MutableInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Vladyslav_Vinnyk on 12/16/2016.
 */
@Component
public class EngToRusTransliterator implements Transliterator {

    @Autowired
    private ConvertingRulesManager convertingRulesManager;

    @Override
    public String transliterate(String input) {
        StringBuilder transliteratedInput = new StringBuilder();
        char[] characters = input.toCharArray();

        MutableInt currentIndex;

        for (currentIndex = new MutableInt(0); currentIndex.getValue() < characters.length; currentIndex.increment()) {
            char currentChar = characters[currentIndex.getValue()];
            List<ConvertingRule> allRulesForSequencesThatStartsFrom = convertingRulesManager.getAllRulesForSequencesThatStartsFrom(currentChar);

            if (allRulesForSequencesThatStartsFrom != null && !allRulesForSequencesThatStartsFrom.isEmpty()) {
                String convertedCharacters = RuleEvaluator.applyRule(characters, currentIndex, allRulesForSequencesThatStartsFrom);
                if (convertedCharacters != null && !convertedCharacters.isEmpty()) {
                    if (ConstantsContainer.Transliterator.EMPTY.equals(convertedCharacters)) {
                        transliteratedInput.append("");
                        continue;
                    }
                    transliteratedInput.append(convertedCharacters);
                    continue;
                }
            }
            transliteratedInput.append(EngToRusCharMapperContainer.convertToRus(String.valueOf(currentChar)));
        }

        return transliteratedInput.toString();
    }
}