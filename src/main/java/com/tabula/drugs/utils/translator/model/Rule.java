package com.tabula.drugs.utils.translator.model;

/**
 * @author Vladyslav_Vinnyk on 12/16/2016.
 */
public interface Rule {
    Character getFirstCharacter();

    String applyFunction(String input, Integer index);
}
