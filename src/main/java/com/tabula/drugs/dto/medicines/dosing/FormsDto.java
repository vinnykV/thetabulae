package com.tabula.drugs.dto.medicines.dosing;

import com.tabula.drugs.model.medicines.dosing.Forms;

import javax.persistence.Column;

/**
 * @author Vladyslav_Vinnyk on 12/26/2016.
 */
public class FormsDto {
    private Long id;

    private String injectable;

    private String powderForInjections;

    private String oralSolution;

    private String tablet;

    private String tabletDelayed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInjectable() {
        return injectable;
    }

    public void setInjectable(String injectable) {
        this.injectable = injectable;
    }

    public String getPowderForInjections() {
        return powderForInjections;
    }

    public void setPowderForInjections(String powderForInjections) {
        this.powderForInjections = powderForInjections;
    }

    public String getOralSolution() {
        return oralSolution;
    }

    public void setOralSolution(String oralSolution) {
        this.oralSolution = oralSolution;
    }

    public String getTablet() {
        return tablet;
    }

    public void setTablet(String tablet) {
        this.tablet = tablet;
    }

    public String getTabletDelayed() {
        return tabletDelayed;
    }

    public void setTabletDelayed(String tabletDelayed) {
        this.tabletDelayed = tabletDelayed;
    }

    public Forms convertToForms() {
        Forms forms = new Forms();

        forms.setId(id);
        forms.setTablet(tablet);
        forms.setInjectable(injectable);
        forms.setOralSolution(oralSolution);
        forms.setPowderForInjections(powderForInjections);
        forms.setTabletDelayed(tabletDelayed);

        return forms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FormsDto formsDto = (FormsDto) o;

        if (id != null ? !id.equals(formsDto.id) : formsDto.id != null) return false;
        if (injectable != null ? !injectable.equals(formsDto.injectable) : formsDto.injectable != null) return false;
        if (powderForInjections != null ? !powderForInjections.equals(formsDto.powderForInjections) : formsDto.powderForInjections != null)
            return false;
        if (oralSolution != null ? !oralSolution.equals(formsDto.oralSolution) : formsDto.oralSolution != null)
            return false;
        if (tablet != null ? !tablet.equals(formsDto.tablet) : formsDto.tablet != null) return false;
        return tabletDelayed != null ? tabletDelayed.equals(formsDto.tabletDelayed) : formsDto.tabletDelayed == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (injectable != null ? injectable.hashCode() : 0);
        result = 31 * result + (powderForInjections != null ? powderForInjections.hashCode() : 0);
        result = 31 * result + (oralSolution != null ? oralSolution.hashCode() : 0);
        result = 31 * result + (tablet != null ? tablet.hashCode() : 0);
        result = 31 * result + (tabletDelayed != null ? tabletDelayed.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FormsDto{" +
                "id=" + id +
                ", injectable='" + injectable + '\'' +
                ", powderForInjections='" + powderForInjections + '\'' +
                ", oralSolution='" + oralSolution + '\'' +
                ", tablet='" + tablet + '\'' +
                ", tabletDelayed='" + tabletDelayed + '\'' +
                '}';
    }
}
