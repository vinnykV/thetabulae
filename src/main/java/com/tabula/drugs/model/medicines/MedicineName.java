package com.tabula.drugs.model.medicines.dosing;

import java.util.List;

/**
 * @author Vladyslav_Vinnyk on 12/21/2016.
 */
public class MedicineName {
    private List<String> engName;

    private List<String> rusName;

    public List<String> getEngName() {
        return engName;
    }

    public void setEngName(List<String> engName) {
        this.engName = engName;
    }

    public List<String> getRusName() {
        return rusName;
    }

    public void setRusName(List<String> rusName) {
        this.rusName = rusName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedicineName that = (MedicineName) o;

        if (engName != null ? !engName.equals(that.engName) : that.engName != null) return false;
        return rusName != null ? rusName.equals(that.rusName) : that.rusName == null;

    }

    @Override
    public int hashCode() {
        int result = engName != null ? engName.hashCode() : 0;
        result = 31 * result + (rusName != null ? rusName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MedicineName{" +
                "engName=" + engName +
                ", rusName=" + rusName +
                '}';
    }
}
