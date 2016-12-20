package com.tabula.drugs.utils.translator.containers.entity;

import com.tabula.drugs.utils.translator.containers.RulesContainer;
import com.tabula.drugs.utils.translator.model.ConvertingRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Vladyslav_Vinnyk on 12/20/2016.
 */
public abstract class BaseRuleContainer {
    protected Map<Character, Set<ConvertingRule>> rules;

    public BaseRuleContainer() {
        this.rules = new HashMap<>();
    }

    protected void addRule(ConvertingRule convertingRule) {
        Character firstCharacter = convertingRule.getFirstCharacter();

        if (!rules.containsKey(firstCharacter)) {
            rules.put(firstCharacter, new HashSet<>());
        }

        Set<ConvertingRule> convertingRules = rules.get(firstCharacter);
        convertingRules.add(convertingRule);
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

    private final static class SortBySequenceLength implements Comparator<ConvertingRule> {
        public int compare(ConvertingRule rule1, ConvertingRule rule2) {
            return Integer.valueOf(rule2.getCharSequence().length()).
                    compareTo(Integer.valueOf(rule1.getCharSequence().length()));
        }
    }

}
