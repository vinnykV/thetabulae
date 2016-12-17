package com.tabula.drugs.utils.translator.containers.impl;

import com.tabula.drugs.utils.translator.containers.RulesContainer;
import com.tabula.drugs.utils.translator.containers.RulesContainerMap;
import com.tabula.drugs.utils.translator.containers.api.ConvertingRulesManager;
import com.tabula.drugs.utils.translator.model.ConvertingRule;
import com.tabula.drugs.utils.translator.model.Language;
import com.tabula.drugs.utils.translator.utils.CharacterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Vladyslav_Vinnyk on 12/17/2016.
 */
@Component
public class ConvertingRulesManagerImpl implements ConvertingRulesManager {
    @Autowired
    private RulesContainerMap containerMap;

    @Override
    public List<ConvertingRule> getAllRulesForSequencesThatStartsFrom(Character character) {
        RulesContainer rulesContainer = getRulesContainerCorrespondingLanguage(character);
        return rulesContainer.getAllRulesForSequencesThatStartsFrom(character);
    }

    private RulesContainer getRulesContainerCorrespondingLanguage(Character character) {
        Language characterLanguage = CharacterUtils.evaluateCharacterLanguage(character);
        if (containerMap.containsKey(characterLanguage)) {
            return containerMap.get(characterLanguage);
        }

        throw new RuntimeException("Cant choose Rules Container for specified character");
    }
}