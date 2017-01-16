package com.tabula.drugs.dto.medicines;

import com.tabula.drugs.dto.medicines.adverseeffect.AdverseEffectsDto;
import com.tabula.drugs.dto.medicines.dosing.DosingAndUsingDto;
import com.tabula.drugs.dto.medicines.pharmacology.PharmacologyDto;
import com.tabula.drugs.dto.medicines.pregnancy.PregnancyDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vladyslav_Vinnyk on 12/26/2016.
 */
public class MedicineDto {
    private Long id;

    private String name;

    private DosingAndUsingDto dosingAndUsing;

    private List<AdverseEffectsDto> adverseEffects = new ArrayList<>();

    private PregnancyDto pregnancy;

    private PharmacologyDto pharmacology;

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

    public DosingAndUsingDto getDosingAndUsing() {
        return dosingAndUsing;
    }

    public void setDosingAndUsing(DosingAndUsingDto dosingAndUsing) {
        this.dosingAndUsing = dosingAndUsing;
    }

    public List<AdverseEffectsDto> getAdverseEffects() {
        return adverseEffects;
    }

    public void setAdverseEffects(List<AdverseEffectsDto> adverseEffects) {
        this.adverseEffects = adverseEffects;
    }

    public PregnancyDto getPregnancy() {
        return pregnancy;
    }

    public void setPregnancy(PregnancyDto pregnancy) {
        this.pregnancy = pregnancy;
    }

    public PharmacologyDto getPharmacology() {
        return pharmacology;
    }

    public void setPharmacology(PharmacologyDto pharmacology) {
        this.pharmacology = pharmacology;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedicineDto that = (MedicineDto) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dosingAndUsing != null ? !dosingAndUsing.equals(that.dosingAndUsing) : that.dosingAndUsing != null)
            return false;
        if (adverseEffects != null ? !adverseEffects.equals(that.adverseEffects) : that.adverseEffects != null)
            return false;
        if (pregnancy != null ? !pregnancy.equals(that.pregnancy) : that.pregnancy != null) return false;
        return pharmacology != null ? pharmacology.equals(that.pharmacology) : that.pharmacology == null;

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

    @Override
    public String toString() {
        return "MedicineDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dosingAndUsing=" + dosingAndUsing +
                ", adverseEffects=" + adverseEffects +
                ", pregnancy=" + pregnancy +
                ", pharmacology=" + pharmacology +
                '}';
    }
}