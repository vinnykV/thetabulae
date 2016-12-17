package com.tabula.drugs.utils.translator.containers.api;

import com.tabula.drugs.utils.translator.model.ConvertingRule;

import java.util.List;

/**
 * @author Vladyslav_Vinnyk on 12/17/2016.
 */
public interface ConvertingRulesManager {
    List<ConvertingRule> getAllRulesForSequencesThatStartsFrom(Character character);
}
