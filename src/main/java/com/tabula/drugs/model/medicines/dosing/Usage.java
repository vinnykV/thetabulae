package com.tabula.drugs.model.medicines.dosing;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vladyslav_Vinnyk on 12/22/2016.
 */
@Entity
public class Usage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "forms_id")
    private Forms forms;

    @OneToMany(mappedBy = "usage", cascade = CascadeType.ALL)
    private List<Dose> doses = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Forms getForms() {
        return forms;
    }

    public void setForms(Forms forms) {
        this.forms = forms;
    }

    public List<Dose> getDoses() {
        return doses;
    }

    public void setDoses(List<Dose> doses) {
        this.doses = doses;
    }

    public void addDoses(List<Dose> doses) {
        for (Dose dose : doses) {
            dose.setUsage(this);
            this.doses.add(dose);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usage usage = (Usage) o;

        if (id != null ? !id.equals(usage.id) : usage.id != null) return false;
        if (forms != null ? !forms.equals(usage.forms) : usage.forms != null) return false;
        return doses != null ? doses.equals(usage.doses) : usage.doses == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (forms != null ? forms.hashCode() : 0);
        result = 31 * result + (doses != null ? doses.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Usage{" +
                "id=" + id +
                ", forms=" + forms +
                ", doses=" + doses +
                '}';
    }
}
