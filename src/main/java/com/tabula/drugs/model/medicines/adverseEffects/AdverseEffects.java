package com.tabula.drugs.model.medicines.adverseEffects;

import com.tabula.drugs.model.medicines.Medicine;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Vladyslav_Vinnyk on 12/21/2016.
 */
@Entity
public class AdverseEffects implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;

    @Enumerated(EnumType.STRING)
    private Frequency frequency;

    @Column(name = "description", length = 1024)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
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

        AdverseEffects that = (AdverseEffects) o;

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
        return "AdverseEffects{" +
                "id=" + id +
                ", frequency=" + frequency +
                ", description='" + description + '\'' +
                '}';
    }
}
