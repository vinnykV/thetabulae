package com.tabula.drugs.dto;

import org.apache.commons.lang3.text.WordUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vladyslav_Vinnyk on 12/21/2016.
 */
public class DrugDto {
    private String rxcui;

    private List<String> names;

    private List<String> rusNames;

    public void addName(String name) {
        if (names == null) {
            names = new ArrayList<>();
        }
        names.add(WordUtils.capitalize(name));
    }

    public void addRusName(String name) {
        if (rusNames == null) {
            rusNames = new ArrayList<>();
        }
        rusNames.add(WordUtils.capitalize(name));
    }

    public String getRxcui() {
        return rxcui;
    }

    public void setRxcui(String rxcui) {
        this.rxcui = rxcui;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        List<String> newList = capitalizeList(names);
        this.names = newList;
    }

    public List<String> getRusNames() {
        return rusNames;
    }

    public void setRusNames(List<String> rusNames) {
        List<String> newList = capitalizeList(rusNames);
        this.rusNames = newList;
    }

    private List<String> capitalizeList(List<String> names) {
        List<String> newList = new ArrayList<>(names);
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            name = WordUtils.capitalize(name);
            newList.set(i, name);
        }
        return newList;
    }

    @Override
    public String toString() {
        return "DrugDto{" +
                "rxcui='" + rxcui + '\'' +
                ", names=" + names +
                ", rusNames=" + rusNames +
                '}';
    }
}
