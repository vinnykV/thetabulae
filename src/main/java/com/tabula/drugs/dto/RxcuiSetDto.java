package com.tabula.drugs.dto;

import java.util.Set;

/**
 * @author Vladyslav_Vinnyk on 12/21/2016.
 */
public class RxcuiSetDto {
    private Set<String> rxcuis;

    public Set<String> getRxcuis() {
        return rxcuis;
    }

    public void setRxcuis(Set<String> rxcuis) {
        this.rxcuis = rxcuis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RxcuiSetDto that = (RxcuiSetDto) o;

        return rxcuis != null ? rxcuis.equals(that.rxcuis) : that.rxcuis == null;

    }

    @Override
    public int hashCode() {
        return rxcuis != null ? rxcuis.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "RxcuiSetDto{" +
                "rxcuis=" + rxcuis +
                '}';
    }
}
