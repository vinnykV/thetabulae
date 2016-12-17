package com.tabula.drugs.utils.translator.containers;

import com.tabula.drugs.utils.translator.model.ConvertingRule;
import com.tabula.drugs.utils.translator.model.Language;

import java.util.List;

/**
 * @author Vladyslav_Vinnyk on 12/17/2016.
 */
public interface RulesContainer {
    Language getSourceLanguage();

    List<ConvertingRule> getAllRulesForSequencesThatStartsFrom(Character character);
}
