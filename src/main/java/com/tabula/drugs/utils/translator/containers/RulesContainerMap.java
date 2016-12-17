package com.tabula.drugs.utils.translator.containers;

import com.tabula.drugs.utils.translator.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Vladyslav_Vinnyk on 12/17/2016.
 */
@Repository
public class RulesContainerMap implements Map<Language, RulesContainer> {
    @Autowired
    private Set<RulesContainer> allRuleContainers;

    private Map<Language, RulesContainer> languageToRulesContainer;

    @PostConstruct
    public void init() {
        this.languageToRulesContainer = new HashMap<>();
        for (RulesContainer ruleContainer : allRuleContainers) {
            languageToRulesContainer.put(ruleContainer.getSourceLanguage(), ruleContainer);
        }
    }

    @Override
    public int size() {
        return languageToRulesContainer.size();
    }

    @Override
    public boolean isEmpty() {
        return languageToRulesContainer.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return languageToRulesContainer.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return languageToRulesContainer.containsValue(value);
    }

    @Override
    public RulesContainer get(Object key) {
        return languageToRulesContainer.get(key);
    }

    @Override
    public RulesContainer put(Language key, RulesContainer value) {
        return languageToRulesContainer.put(key, value);
    }

    @Override
    public RulesContainer remove(Object key) {
        return languageToRulesContainer.remove(key);
    }

    @Override
    public void putAll(Map<? extends Language, ? extends RulesContainer> m) {
        languageToRulesContainer.putAll(m);
    }

    @Override
    public void clear() {
        languageToRulesContainer.clear();
    }

    @Override
    public Set<Language> keySet() {
        return languageToRulesContainer.keySet();
    }

    @Override
    public Collection<RulesContainer> values() {
        return languageToRulesContainer.values();
    }

    @Override
    public Set<Entry<Language, RulesContainer>> entrySet() {
        return languageToRulesContainer.entrySet();
    }
}
