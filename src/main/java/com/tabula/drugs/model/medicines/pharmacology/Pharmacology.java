package com.tabula.drugs.model.medicines.pharmacology;

import com.tabula.drugs.model.medicines.Medicine;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Vladyslav_Vinnyk on 12/21/2016.
 */
@Entity
public class Pharmacology implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "pharmacology", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE})
    private Medicine medicine;

    @Column(name = "mechanism_of_action", length = 2054)
    private String mechanismOfAction;

    @Column(name = "absorption", length = 2054)
    private String absorption;

    @Column(name = "distribution", length = 2054)
    private String distribution;

    @Column(name = "metabolism", length = 2054)
    private String metabolism;

    @Column(name = "elimination", length = 2054)
    private String elimination;

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

    public String getMechanismOfAction() {
        return mechanismOfAction;
    }

    public void setMechanismOfAction(String mechanismOfAction) {
        this.mechanismOfAction = mechanismOfAction;
    }

    public String getAbsorption() {
        return absorption;
    }

    public void setAbsorption(String absorption) {
        this.absorption = absorption;
    }

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }

    public String getMetabolism() {
        return metabolism;
    }

    public void setMetabolism(String metabolism) {
        this.metabolism = metabolism;
    }

    public String getElimination() {
        return elimination;
    }

    public void setElimination(String elimination) {
        this.elimination = elimination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pharmacology that = (Pharmacology) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (mechanismOfAction != null ? !mechanismOfAction.equals(that.mechanismOfAction) : that.mechanismOfAction != null)
            return false;
        if (absorption != null ? !absorption.equals(that.absorption) : that.absorption != null) return false;
        if (distribution != null ? !distribution.equals(that.distribution) : that.distribution != null) return false;
        if (metabolism != null ? !metabolism.equals(that.metabolism) : that.metabolism != null) return false;
        return elimination != null ? elimination.equals(that.elimination) : that.elimination == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (mechanismOfAction != null ? mechanismOfAction.hashCode() : 0);
        result = 31 * result + (absorption != null ? absorption.hashCode() : 0);
        result = 31 * result + (distribution != null ? distribution.hashCode() : 0);
        result = 31 * result + (metabolism != null ? metabolism.hashCode() : 0);
        result = 31 * result + (elimination != null ? elimination.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pharmacology{" +
                "id=" + id +
                ", mechanismOfAction='" + mechanismOfAction + '\'' +
                ", absorption='" + absorption + '\'' +
                ", distribution='" + distribution + '\'' +
                ", metabolism='" + metabolism + '\'' +
                ", elimination='" + elimination + '\'' +
                '}';
    }
}