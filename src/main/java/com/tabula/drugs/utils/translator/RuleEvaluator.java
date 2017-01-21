package com.tabula.drugs.utils.translator;

import com.tabula.drugs.utils.ConstantsContainer;
import com.tabula.drugs.utils.translator.model.ConvertingRule;
import org.apache.commons.lang3.mutable.MutableInt;

import java.util.List;

/**
 * @author Vladyslav_Vinnyk on 12/16/2016.
 */
public class RuleEvaluator {
    public static String applyRule(char[] characters, MutableInt mutableIndex, List<ConvertingRule> rule) {
        int index = mutableIndex.getValue();
        StringBuilder result = new StringBuilder();

        char[] subSequence = new char[characters.length - index];
        System.arraycopy(characters, index, subSequence, 0, characters.length - index);

        for (ConvertingRule convertingRule : rule) {
            String ruleCharSequence = convertingRule.getCharSequence();

            String functionResult = convertingRule.applyFunction(String.valueOf(characters), mutableIndex.getValue());

            if (ConstantsContainer.Transliterator.NOT_APPLIED.equals(functionResult)) {
                continue;
            }

            if (functionResult != null && !functionResult.isEmpty()) {
                result.append(functionResult);
                mutableIndex.add(convertingRule.getCharSequence().length() - 1);
                break;
            }

            if (characters.length >= (index + ruleCharSequence.length()) &&
                    (String.valueOf(characters).substring(index, index + ruleCharSequence.length()).equals(ruleCharSequence))) {
                result.append(convertingRule.getRusCharSequence());
                mutableIndex.add(convertingRule.getCharSequence().length() - 1);
                break;
            }

        }

        return result.toString();
    }
}
