package com.tabula.drugs.model.medicines.dosing;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Vladyslav_Vinnyk on 12/22/2016.
 */
@Entity
public class Dose {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    //TODO Replace to id or smth
    private String diseaseName;

    private String doseDiscription;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="usage_id")
    private Usage usage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDoseDiscription() {
        return doseDiscription;
    }

    public void setDoseDiscription(String doseDiscription) {
        this.doseDiscription = doseDiscription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dose dose = (Dose) o;

        if (id != null ? !id.equals(dose.id) : dose.id != null) return false;
        if (diseaseName != null ? !diseaseName.equals(dose.diseaseName) : dose.diseaseName != null) return false;
        return doseDiscription != null ? doseDiscription.equals(dose.doseDiscription) : dose.doseDiscription == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (diseaseName != null ? diseaseName.hashCode() : 0);
        result = 31 * result + (doseDiscription != null ? doseDiscription.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Doses{" +
                "id=" + id +
                ", diseaseName='" + diseaseName + '\'' +
                ", doseDiscription='" + doseDiscription + '\'' +
                '}';
    }
}
