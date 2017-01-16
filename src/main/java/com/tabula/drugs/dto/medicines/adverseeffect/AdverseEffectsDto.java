package com.tabula.drugs.dto.medicines.adverseeffect;

import com.tabula.drugs.model.medicines.adverseEffects.Frequency;

/**
 * @author Vladyslav_Vinnyk on 12/26/2016.
 */
public class AdverseEffectsDto {
    private Long id;

    private Frequency frequency;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
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

        AdverseEffectsDto that = (AdverseEffectsDto) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (frequency != that.frequency) return false;
        return description != null ? description.equals(that.description) : that.description == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (frequency != null ? frequency.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AdverseEffectsDto{" +
                "id=" + id +
                ", frequency=" + frequency +
                ", description='" + description + '\'' +
                '}';
    }
}
