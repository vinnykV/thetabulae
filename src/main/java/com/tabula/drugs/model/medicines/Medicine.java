package com.tabula.drugs.model.medicines;

import com.tabula.drugs.model.medicines.dosing.DosingAndUsing;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author Vladyslav_Vinnyk on 12/21/2016.
 */
@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private DosingAndUsing dosingAndUsing;

//    private MedicineName medicineName;
//
//    private BrandNames brandNames;


//    private Iteractions iteractions;
//
//    private AdverseEffects adverseEffects;
//
//    private Pregnancy pregnancy;
//
//    private Pharmacology pharmacology;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DosingAndUsing getDosingAndUsing() {
        return dosingAndUsing;
    }

    public void setDosingAndUsing(DosingAndUsing dosingAndUsing) {
        this.dosingAndUsing = dosingAndUsing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medicine medicine = (Medicine) o;

        if (id != null ? !id.equals(medicine.id) : medicine.id != null) return false;
        if (name != null ? !name.equals(medicine.name) : medicine.name != null) return false;
        return dosingAndUsing != null ? dosingAndUsing.equals(medicine.dosingAndUsing) : medicine.dosingAndUsing == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dosingAndUsing != null ? dosingAndUsing.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dosingAndUsing=" + dosingAndUsing +
                '}';
    }
}
