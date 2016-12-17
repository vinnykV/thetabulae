package com.tabula.drugs.utils.translator.containers.entity;

import com.tabula.drugs.utils.ConstantsContainer;
import com.tabula.drugs.utils.translator.containers.RulesContainer;
import com.tabula.drugs.utils.translator.model.ConvertingRule;
import com.tabula.drugs.utils.translator.model.Language;
import org.apache.commons.codec.language.bm.Lang;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Vladyslav_Vinnyk on 12/16/2016.
 */
@Component
public class EngToRusConvertingRulesContainer implements RulesContainer {
    private Language sourceLanguage = Language.ENG;

    private Map<Character, Set<ConvertingRule>> rules;

    public EngToRusConvertingRulesContainer() {
        rules = new HashMap<>();

        createDirectAndReverseRuleThenAddToRuleMap("th", "т");
        createDirectAndReverseRuleThenAddToRuleMap("ph", "ф");
        createDirectAndReverseRuleThenAddToRuleMap("grel", "грель");
        createDirectAndReverseRuleThenAddToRuleMap("qu", "кв");
        createDirectAndReverseRuleThenAddToRuleMap("ch", "х");
        createDirectAndReverseRuleThenAddToRuleMap("alb", "альб");

        addRule(new ConvertingRule("e", "",
                (String input, Integer index) -> {
                    if (input.length() == index + 1) {
                        return ConstantsContainer.Transliterator.EMPTY;
                    }
                    return ConstantsContainer.Transliterator.NOT_APPLIED;
                }));

        addRule(new ConvertingRule("e", "э",
                (String input, Integer index) -> {
                    if (index == 0) {
                        return "э";
                    }
                    return ConstantsContainer.Transliterator.NOT_APPLIED;
                }));

        // e, i, y, ae, oe
        addRule(new ConvertingRule("c", "ц",
                (String input, Integer index) -> {
                    if (index + 1 < input.length()) {
                        char nextChar = input.charAt(index + 1);
                        if (nextChar == 'e' || nextChar == 'i' || nextChar == 'y') {
                            return "ц";
                        }
                    }
                    return ConstantsContainer.Transliterator.NOT_APPLIED;
                }));

        // e, i, y, ae, oe
        addRule(new ConvertingRule("s", "з",
                (String input, Integer index) -> {
                    if ((index > 0 && index < input.length() - 1)) {
                        char precedeCharacter = input.charAt(index - 1);
                        char followingCharacter = input.charAt(index + 1);
                        if (isVowel(precedeCharacter) && isVowel(followingCharacter) ||
                                followingCharacter == 'm' || followingCharacter == 'n') {
                            return "з";
                        }
                    }
                    return ConstantsContainer.Transliterator.NOT_APPLIED;
                }));

    }

    public Set<ConvertingRule> getAllRules() {
        Set<ConvertingRule> result = new HashSet<>();
        for (Set<ConvertingRule> rules : this.rules.values()) {
            result.addAll(rules);
        }
        return result;
    }

    public List<ConvertingRule> getAllRulesForSequencesThatStartsFrom(Character character) {
        Set<ConvertingRule> hasSet = rules.get(character);
        List<ConvertingRule> ruleList = new ArrayList<>();
        if (hasSet != null) {
            ruleList.addAll(hasSet);
        }
        Collections.sort(ruleList, new SortBySequenceLength());
        return ruleList;
    }

    private void addRule(ConvertingRule convertingRule) {
        Character firstCharacter = convertingRule.getFirstCharacter();

        if (!rules.containsKey(firstCharacter)) {
            rules.put(firstCharacter, new HashSet<>());
        }

        Set<ConvertingRule> convertingRules = rules.get(firstCharacter);
        convertingRules.add(convertingRule);
    }

    private boolean isVowel(char character) {
        return String.valueOf(character).toLowerCase().matches("[aeiou]");
    }

    private final static class SortBySequenceLength implements Comparator<ConvertingRule> {
        public int compare(ConvertingRule rule1, ConvertingRule rule2) {
            return Integer.valueOf(rule2.getCharSequence().length()).
                    compareTo(Integer.valueOf(rule1.getCharSequence().length()));
        }
    }

    public void createDirectAndReverseRuleThenAddToRuleMap(String engSequence, String rusSequence) {
        addRule(new ConvertingRule(engSequence, rusSequence));
        addRule(new ConvertingRule(rusSequence, engSequence));
    }

    //TODO Better name. Do smth with duplicates
    private void addRuleWithFunctionCasK(String engSequence, String rusSequence) {
        addRule(new ConvertingRule(engSequence, rusSequence,
                (String input, Integer index) -> {
                    if ((index > 0 && index < input.length() - 1)) {
                        char precedeCharacter = input.charAt(index - 1);
                        char followingCharacter = input.charAt(index + 1);
                        if (isVowel(precedeCharacter) && isVowel(followingCharacter)) {
                            return rusSequence;
                        }
                    } else if (index == 0) {
                        return rusSequence;
                    }
                    return ConstantsContainer.Transliterator.NOT_APPLIED;
                }));
        addRule(new ConvertingRule(rusSequence, engSequence,
                (String input, Integer index) -> {
                    if ((index > 0 && index < input.length() - 1)) {
                        char precedeCharacter = input.charAt(index - 1);
                        char followingCharacter = input.charAt(index + 1);
                        if (isVowel(precedeCharacter) && isVowel(followingCharacter)) {
                            return engSequence;
                        }
                    } else if (index == 0) {
                        return engSequence;
                    }
                    return ConstantsContainer.Transliterator.NOT_APPLIED;
                }));
    }

    @Override
    public Language getSourceLanguage() {
        return sourceLanguage;
    }

    public void setSourceLanguage(Language sourceLanguage) {
        this.sourceLanguage = sourceLanguage;
    }
}