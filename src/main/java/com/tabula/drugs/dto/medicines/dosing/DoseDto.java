package com.tabula.drugs.dto.medicines.dosing;

import com.tabula.drugs.model.medicines.dosing.Dose;

/**
 * @author Vladyslav_Vinnyk on 12/26/2016.
 */
public class DoseDto {
    private Long id;

    private String diseaseName;

    private String doseDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDoseDescription() {
        return doseDescription;
    }

    public void setDoseDescription(String doseDescription) {
        this.doseDescription = doseDescription;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public Dose convertToDose() {
        Dose dose = new Dose();

        dose.setId(id);
        dose.setDiseaseName(diseaseName);
        dose.setDoseDescription(doseDescription);

        return dose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DoseDto doseDto = (DoseDto) o;

        if (id != null ? !id.equals(doseDto.id) : doseDto.id != null) return false;
        if (diseaseName != null ? !diseaseName.equals(doseDto.diseaseName) : doseDto.diseaseName != null) return false;
        return doseDescription != null ? doseDescription.equals(doseDto.doseDescription) : doseDto.doseDescription == null;

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
        return "DoseDto{" +
                "id=" + id +
                ", diseaseName='" + diseaseName + '\'' +
                ", doseDescription='" + doseDescription + '\'' +
                '}';
    }
}