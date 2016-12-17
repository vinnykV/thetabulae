package com.tabula.drugs.utils.translator.containers.entity;

import com.tabula.drugs.utils.translator.containers.RulesContainer;
import com.tabula.drugs.utils.translator.model.ConvertingRule;
import com.tabula.drugs.utils.translator.model.Language;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Vladyslav_Vinnyk on 12/17/2016.
 */
@Component
public class RusToEngConvertingRulesContainer implements RulesContainer {
    private Language sourceLanguage = Language.RUS;

    @Override
    public List<ConvertingRule> getAllRulesForSequencesThatStartsFrom(Character character) {
        throw new UnsupportedOperationException("Not implemented Yes");
    }

    public Language getSourceLanguage() {
        return sourceLanguage;
    }

    public void setSourceLanguage(Language sourceLanguage) {
        this.sourceLanguage = sourceLanguage;
    }
}
