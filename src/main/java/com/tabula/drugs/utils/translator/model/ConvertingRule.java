package com.tabula.drugs.utils.translator.model;

import com.tabula.drugs.model.functions.Function;
import com.tabula.drugs.utils.ConstantsContainer;

/**
 * @author Vladyslav_Vinnyk on 12/16/2016.
 */
public class ConvertingRule implements Rule {
    private String charSequence;
    private String rusCharSequence;

    private Function function;

    public ConvertingRule(String charSequence, String rusCharSequence) {
        this(charSequence, rusCharSequence, (input, index) -> null);
    }

    public ConvertingRule(String charSequence, String rusCharSequence, Function function) {
        this.charSequence = charSequence;
        this.rusCharSequence = rusCharSequence;
        this.function = function;
    }


    @Override
    public Character getFirstCharacter() {
        return charSequence.charAt(0);
    }

    @Override
    public String applyFunction(String input, Integer index) {
        if (function == null) {
            return null;
        }
        return (String) function.aply(input, index);
    }

    public String getCharSequence() {
        return charSequence;
    }

    public void setCharSequence(String charSequence) {
        this.charSequence = charSequence;
    }

    public String getRusCharSequence() {
        return rusCharSequence;
    }

    public void setRusCharSequence(String rusCharSequence) {
        this.rusCharSequence = rusCharSequence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConvertingRule that = (ConvertingRule) o;

        if (charSequence != null ? !charSequence.equals(that.charSequence) : that.charSequence != null) return false;
        return rusCharSequence != null ? rusCharSequence.equals(that.rusCharSequence) : that.rusCharSequence == null;
    }

    @Override
    public int hashCode() {
        int result = charSequence != null ? charSequence.hashCode() : 0;
        result = 31 * result + (rusCharSequence != null ? rusCharSequence.hashCode() : 0);
        return result;
    }

}
