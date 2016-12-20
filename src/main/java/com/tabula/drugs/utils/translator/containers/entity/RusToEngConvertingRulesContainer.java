package com.tabula.drugs.utils.translator.containers.entity;

import com.tabula.drugs.utils.ConstantsContainer;
import com.tabula.drugs.utils.translator.containers.RulesContainer;
import com.tabula.drugs.utils.translator.model.ConvertingRule;
import com.tabula.drugs.utils.translator.model.Language;
import org.springframework.stereotype.Component;

/**
 * @author Vladyslav_Vinnyk on 12/17/2016.
 */
@Component
public class RusToEngConvertingRulesContainer extends BaseRuleContainer implements RulesContainer {
    private Language sourceLanguage = Language.RUS;

    public RusToEngConvertingRulesContainer() {
        super();
        addRule(new ConvertingRule("и", "i"));
        addRule(new ConvertingRule("ф", "ph"));
        addRule(new ConvertingRule("кс", "x"));
        addRule(new ConvertingRule("в", "v"));
        addRule(new ConvertingRule("гр", "gr"));
        addRule(new ConvertingRule("циллин", "cillin"));
        addRule(new ConvertingRule("празол", "prazole"));
        addRule(new ConvertingRule("статин", "statin"));
        addRule(new ConvertingRule("мицин", "mycin"));
        addRule(new ConvertingRule("гидро", "hydro"));
        addRule(new ConvertingRule("тиазид", "thiazide"));
        addRule(new ConvertingRule("тр", "thr"));
        addRule(new ConvertingRule("ази", "azi"));
        addRule(new ConvertingRule("х", "ch"));
        addRule(new ConvertingRule("фен", "fen"));
        addRule(new ConvertingRule("сартан", "sartan"));
        addRule(new ConvertingRule("кв", "qu"));
        addRule(new ConvertingRule("таз", "thaz"));
        addRule(new ConvertingRule("флу", "flu"));
        addRule(new ConvertingRule("казон", "casone"));
        addRule(new ConvertingRule("лексин", "lexin"));
        addRule(new ConvertingRule("цикло", "cyclo"));
        addRule(new ConvertingRule("метил", "methyl"));
        addRule(new ConvertingRule("фексо", "fexo"));
        addRule(new ConvertingRule("фени", "pheni"));
        addRule(new ConvertingRule("фенидат", "phenidate"));
        addComplexRules();
    }

    @Override
    public Language getSourceLanguage() {
        return sourceLanguage;
    }

    private void addComplexRules() {
        addRule(new ConvertingRule("н", "ne", (String input, Integer index) -> {
            if (input.length() == index + 1) {
                return "ne";
            }
            return ConstantsContainer.Transliterator.NOT_APPLIED;
        }));

        addRule(new ConvertingRule("ь", "", (String input, Integer index) -> {
            return ConstantsContainer.Transliterator.EMPTY;
        }));

        // e, i, y, ae, oe
        addRule(new ConvertingRule("ц", "c",
                (String input, Integer index) -> {
                    if (index + 1 < input.length()) {
                        char nextChar = input.charAt(index + 1);
                        if (nextChar == 'е' || nextChar == 'и') {
                            return "c";
                        }
                    }
                    return ConstantsContainer.Transliterator.NOT_APPLIED;
                }));

        //TODO Can be improved by usage code of EngToRusConverter
        // e, i, y, ae, oe
        addRule(new ConvertingRule("з", "s",
                (String input, Integer index) -> {
                    if ((index > 0 && index < input.length() - 1)) {
                        char precedeCharacter = input.charAt(index - 1);
                        char followingCharacter = input.charAt(index + 1);
                        if (isVowel(precedeCharacter) && isVowel(followingCharacter) ||
                                followingCharacter == 'м' || followingCharacter == 'н') {
                            return "s";
                        }
                    }
                    return ConstantsContainer.Transliterator.NOT_APPLIED;
                }));


        addRule(new ConvertingRule("э", "e",
                (String input, Integer index) -> {
                    if (index == 0) {
                        return "e";
                    }
                    return ConstantsContainer.Transliterator.NOT_APPLIED;
                }));

        addRule(new ConvertingRule("к", "c",
                (String input, Integer index) -> {
                    if (index == 0) {
                        return "c";
                    }
                    return ConstantsContainer.Transliterator.NOT_APPLIED;
                }));
    }

    private boolean isVowel(char character) {
        return String.valueOf(character).toLowerCase().matches("[аяуюиыэеоё]");
    }

}