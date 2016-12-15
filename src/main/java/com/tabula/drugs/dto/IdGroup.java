package com.tabula.drugs.dto;

/**
 * @author Vladyslav_Vinnyk on 12/15/2016.
 */
public class IdGroup {
    private String name;
    private String rxnormId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRxnormId() {
        return rxnormId;
    }

    public void setRxnormId(String rxnormId) {
        this.rxnormId = rxnormId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IdGroup idGroup = (IdGroup) o;

        if (name != null ? !name.equals(idGroup.name) : idGroup.name != null) return false;
        return rxnormId != null ? rxnormId.equals(idGroup.rxnormId) : idGroup.rxnormId == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (rxnormId != null ? rxnormId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "IdGroup{" +
                "name='" + name + '\'' +
                ", rxnormId='" + rxnormId + '\'' +
                '}';
    }
}
