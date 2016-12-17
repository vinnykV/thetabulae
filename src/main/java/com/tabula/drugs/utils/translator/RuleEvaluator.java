package com.tabula.drugs.utils.translator;

import com.tabula.drugs.utils.ConstantsContainer;
import com.tabula.drugs.utils.translator.model.ConvertingRule;
import com.tabula.drugs.utils.translator.model.Rule;
import org.apache.commons.lang3.mutable.MutableInt;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * @author Vladyslav_Vinnyk on 12/16/2016.
 */
public class RuleEvaluator {
    public static String applyRule(char[] characters, MutableInt mutableIndex, List<ConvertingRule> rule) {
        int index = mutableIndex.getValue();
        StringBuilder result = new StringBuilder();

        char[] subSequence = new char[characters.length - index];
        System.arraycopy(characters, index, subSequence, 0, characters.length - index);
        CharSequence sequence = java.nio.CharBuffer.wrap(subSequence);

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

            if ((String.valueOf(sequence).contains(ruleCharSequence))) {
                result.append(convertingRule.getRusCharSequence());
                mutableIndex.add(convertingRule.getCharSequence().length() - 1);
                break;
            }

        }

        return result.toString();
    }
}
