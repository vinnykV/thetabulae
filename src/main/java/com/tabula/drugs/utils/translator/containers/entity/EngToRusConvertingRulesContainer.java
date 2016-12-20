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
public class EngToRusConvertingRulesContainer extends BaseRuleContainer implements RulesContainer {
    private Language sourceLanguage = Language.ENG;

    public EngToRusConvertingRulesContainer() {
        super();
        addRule(new ConvertingRule("th", "т"));
        addRule(new ConvertingRule("ph", "ф"));
        addRule(new ConvertingRule("grel", "грель"));
        addRule(new ConvertingRule("qu", "кв"));
        addRule(new ConvertingRule("ch", "х"));
        addRule(new ConvertingRule("alb", "альб"));

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

    @Override
    public Language getSourceLanguage() {
        return sourceLanguage;
    }

    private boolean isVowel(char character) {
        return String.valueOf(character).toLowerCase().matches("[aeiou]");
    }

}