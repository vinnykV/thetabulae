package com.tabula.drugs.model.medicines.interaction;

import com.tabula.drugs.model.medicines.Medicine;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Vladyslav_Vinnyk on 12/25/2016.
 */
public class Interaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private InteractionSeverity severity;

    private String description;

    private Long firstMedicineId;

    private Long secondMedicineId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InteractionSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(InteractionSeverity severity) {
        this.severity = severity;
    }

    public Long getFirstMedicineId() {
        return firstMedicineId;
    }

    public void setFirstMedicineId(Long firstMedicineId) {
        this.firstMedicineId = firstMedicineId;
    }

    public Long getSecondMedicineId() {
        return secondMedicineId;
    }

    public void setSecondMedicineId(Long secondMedicineId) {
        this.secondMedicineId = secondMedicineId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Interaction that = (Interaction) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (severity != that.severity) return false;
        if (firstMedicineId != null ? !firstMedicineId.equals(that.firstMedicineId) : that.firstMedicineId != null)
            return false;
        if (secondMedicineId != null ? !secondMedicineId.equals(that.secondMedicineId) : that.secondMedicineId != null)
            return false;
        return description != null ? description.equals(that.description) : that.description == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (severity != null ? severity.hashCode() : 0);
        result = 31 * result + (firstMedicineId != null ? firstMedicineId.hashCode() : 0);
        result = 31 * result + (secondMedicineId != null ? secondMedicineId.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Interaction{" +
                "id=" + id +
                ", severity=" + severity +
                ", firstMedicineId=" + firstMedicineId +
                ", secondMedicineId=" + secondMedicineId +
                ", description='" + description + '\'' +
                '}';
    }
}