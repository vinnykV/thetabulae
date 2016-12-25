package com.tabula.drugs.model.medicines.dosing;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usage_id")
    private Usage usage;

    private Long diseaseId;

    @Column(name = "dose_description", length = 1024)
    private String doseDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Long diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getDoseDescription() {
        return doseDescription;
    }

    public void setDoseDescription(String doseDescription) {
        this.doseDescription = doseDescription;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dose dose = (Dose) o;

        if (id != null ? !id.equals(dose.id) : dose.id != null) return false;
        if (diseaseId != null ? !diseaseId.equals(dose.diseaseId) : dose.diseaseId != null) return false;
        return doseDescription != null ? doseDescription.equals(dose.doseDescription) : dose.doseDescription == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (diseaseId != null ? diseaseId.hashCode() : 0);
        result = 31 * result + (doseDescription != null ? doseDescription.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Doses{" +
                "id=" + id +
                ", diseaseId='" + diseaseId + '\'' +
                ", doseDescription='" + doseDescription + '\'' +
                '}';
    }
}
