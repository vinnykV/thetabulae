package com.tabula.drugs.model.medicines.dosing;

import com.tabula.drugs.model.medicines.Medicine;

import javax.persistence.*;

/**
 * @author Vladyslav_Vinnyk on 12/21/2016.
 */
@Entity
public class DosingAndUsing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "dosingAndUsing", cascade = CascadeType.ALL)
    private Medicine medicine;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adult_id")
    private Usage adult;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pediatric_id")
    private Usage pediatric;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usage getAdult() {
        return adult;
    }

    public void setAdult(Usage adult) {
        this.adult = adult;
    }

    public Usage getPediatric() {
        return pediatric;
    }

    public void setPediatric(Usage pediatric) {
        this.pediatric = pediatric;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DosingAndUsing that = (DosingAndUsing) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (adult != null ? !adult.equals(that.adult) : that.adult != null) return false;
        return pediatric != null ? pediatric.equals(that.pediatric) : that.pediatric == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (adult != null ? adult.hashCode() : 0);
        result = 31 * result + (pediatric != null ? pediatric.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DosingAndUsing{" +
                "id=" + id +
                ", adult=" + adult +
                ", pediatric=" + pediatric +
                '}';
    }
}
