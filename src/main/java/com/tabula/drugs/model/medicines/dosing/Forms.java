package com.tabula.drugs.model.medicines.dosing;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Vladyslav_Vinnyk on 12/22/2016.
 */
@Entity
public class Forms implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "injectable", length = 256)
    private String injectable;

    @Column(name = "powder_for_injections", length = 256)
    private String powderForInjections;

    @Column(name = "oral_solution", length = 256)
    private String oralSolution;

    @Column(name = "tablet", length = 256)
    private String tablet;

    @Column(name = "tablet_delayed", length = 256)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Forms forms = (Forms) o;

        if (id != null ? !id.equals(forms.id) : forms.id != null) return false;
        if (injectable != null ? !injectable.equals(forms.injectable) : forms.injectable != null) return false;
        if (powderForInjections != null ? !powderForInjections.equals(forms.powderForInjections) : forms.powderForInjections != null)
            return false;
        if (oralSolution != null ? !oralSolution.equals(forms.oralSolution) : forms.oralSolution != null) return false;
        if (tablet != null ? !tablet.equals(forms.tablet) : forms.tablet != null) return false;
        return tabletDelayed != null ? tabletDelayed.equals(forms.tabletDelayed) : forms.tabletDelayed == null;

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
        return "Forms{" +
                "id=" + id +
                ", injectable='" + injectable + '\'' +
                ", powderForInjections='" + powderForInjections + '\'' +
                ", oralSolution='" + oralSolution + '\'' +
                ", tablet='" + tablet + '\'' +
                ", tabletDelayed='" + tabletDelayed + '\'' +
                '}';
    }
}
