package com.tabula.drugs.model;

import com.tabula.drugs.dto.IdGroup;
import com.tabula.drugs.dto.RxNormDataDto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Vladyslav_Vinnyk on 12/15/2016.
 */
@Entity
@Table(name = "drug_item")
public class Drug {
    @Id
    private String rxnormId;

    private String name;

    private String rusName;

    public Drug(IdGroup idGroup) {
        this.rxnormId = idGroup.getRxnormId();
        this.name = idGroup.getName();
    }

    public String getRxnormId() {
        return rxnormId;
    }

    public void setRxnormId(String rxnormId) {
        this.rxnormId = rxnormId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRusName() {
        return rusName;
    }

    public void setRusName(String rusName) {
        this.rusName = rusName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Drug drug = (Drug) o;

        if (rxnormId != null ? !rxnormId.equals(drug.rxnormId) : drug.rxnormId != null) return false;
        if (name != null ? !name.equals(drug.name) : drug.name != null) return false;
        return rusName != null ? rusName.equals(drug.rusName) : drug.rusName == null;

    }

    @Override
    public int hashCode() {
        int result = rxnormId != null ? rxnormId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (rusName != null ? rusName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "rxnormId='" + rxnormId + '\'' +
                ", name='" + name + '\'' +
                ", rusName='" + rusName + '\'' +
                '}';
    }
}
