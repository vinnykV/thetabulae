package com.tabula.drugs.model.medicines;

import com.tabula.drugs.model.medicines.adverseEffects.AdverseEffects;
import com.tabula.drugs.model.medicines.dosing.DosingAndUsing;
import com.tabula.drugs.model.medicines.interaction.Interaction;
import com.tabula.drugs.model.medicines.pharmacology.Pharmacology;
import com.tabula.drugs.model.medicines.pregnancy.Pregnancy;
import com.tabula.drugs.utils.asserter.Assert;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vladyslav_Vinnyk on 12/21/2016.
 */
@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 256)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dosing_and_using_id")
    private DosingAndUsing dosingAndUsing;

    @OneToMany(mappedBy = "medicine", cascade = CascadeType.ALL)
    private List<AdverseEffects> adverseEffects = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pregnancy_id")
    private Pregnancy pregnancy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pharmacology_id")
    private Pharmacology pharmacology;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "interaction_id")
//    private List<Interaction> interactions = new ArrayList<>();

//    private MedicineName medicineName;
//
//    private BrandNames brandNames;

    public Long getId() {
        return id;
    }

    public Pregnancy getPregnancy() {
        return pregnancy;
    }

    public void setPregnancy(Pregnancy pregnancy) {
        this.pregnancy = pregnancy;
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

    public Pharmacology getPharmacology() {
        return pharmacology;
    }

    public void setPharmacology(Pharmacology pharmacology) {
        this.pharmacology = pharmacology;
    }

    public void setDosingAndUsing(DosingAndUsing dosingAndUsing) {
        this.dosingAndUsing = dosingAndUsing;
    }
//
//    public List<Interaction> getInteractions() {
//        return interactions;
//    }

    public List<AdverseEffects> getAdverseEffects() {
        return adverseEffects;
    }

    public void setAdverseEffects(List<AdverseEffects> adverseEffectsList) {
        for (AdverseEffects adverseEffects : adverseEffectsList) {
            addAdverseEffect(adverseEffects);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medicine medicine = (Medicine) o;

        if (id != null ? !id.equals(medicine.id) : medicine.id != null) return false;
        if (name != null ? !name.equals(medicine.name) : medicine.name != null) return false;
        if (dosingAndUsing != null ? !dosingAndUsing.equals(medicine.dosingAndUsing) : medicine.dosingAndUsing != null)
            return false;
        if (adverseEffects != null ? !adverseEffects.equals(medicine.adverseEffects) : medicine.adverseEffects != null)
            return false;
        if (pregnancy != null ? !pregnancy.equals(medicine.pregnancy) : medicine.pregnancy != null) return false;
        return pharmacology != null ? pharmacology.equals(medicine.pharmacology) : medicine.pharmacology == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dosingAndUsing != null ? dosingAndUsing.hashCode() : 0);
        result = 31 * result + (adverseEffects != null ? adverseEffects.hashCode() : 0);
        result = 31 * result + (pregnancy != null ? pregnancy.hashCode() : 0);
        result = 31 * result + (pharmacology != null ? pharmacology.hashCode() : 0);
        return result;
    }

    public void addAdverseEffect(AdverseEffects adverseEffects) {
        Assert.notNull(adverseEffects);
        adverseEffects.setMedicine(this);
        this.adverseEffects.add(adverseEffects);
    }

//
//    public void setInteractions(List<Interaction> interactions) {
//        this.interactions = interactions;
//    }


//    public void addInteractions(List<Interaction> interactions) {
//        for (Interaction interaction : interactions) {
//            addInteraction(interaction);
//        }
//    }
//
//    public void addInteraction(Interaction interaction) {
//        this.interactions.add(interaction);
//    }


    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dosingAndUsing=" + dosingAndUsing +
                ", adverseEffects=" + adverseEffects +
                ", pregnancy=" + pregnancy +
                ", pharmacology=" + pharmacology +
                '}';
    }
}
