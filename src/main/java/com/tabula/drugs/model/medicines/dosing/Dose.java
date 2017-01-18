package com.tabula.drugs.model.medicines.dosing;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * @author Vladyslav_Vinnyk on 12/22/2016.
 */
@Entity
public class Dose implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usage_id")
    private Usage usage;

    @Column(name = "disease_name", length = 1024)
    private String diseaseName;

    @Column(name = "dose_description", length = 1024)
    private String doseDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDoseDescription() {
        return doseDescription;
    }

    public void setDoseDescription(String doseDescription) {
        this.doseDescription = doseDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Dose dose = (Dose) o;

        if (id != null ? !id.equals(dose.id) : dose.id != null)
            return false;
        if (diseaseName != null ? !diseaseName.equals(dose.diseaseName) : dose.diseaseName != null)
            return false;
        return doseDescription != null ? doseDescription.equals(dose.doseDescription) : dose.doseDescription == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (diseaseName != null ? diseaseName.hashCode() : 0);
        result = 31 * result + (doseDescription != null ? doseDescription.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Dose{" +
                "id=" + id +
                ", diseaseName='" + diseaseName + '\'' +
                ", doseDescription='" + doseDescription + '\'' +
                '}';
    }
}