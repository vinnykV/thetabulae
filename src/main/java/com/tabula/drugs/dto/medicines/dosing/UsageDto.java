package com.tabula.drugs.dto.medicines.dosing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vladyslav_Vinnyk on 12/26/2016.
 */
public class UsageDto {
    private Long id;

    private FormsDto forms;

    private List<DoseDto> doses = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FormsDto getForms() {
        return forms;
    }

    public void setForms(FormsDto forms) {
        this.forms = forms;
    }

    public List<DoseDto> getDoses() {
        return doses;
    }

    public void setDoses(List<DoseDto> doses) {
        this.doses = doses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsageDto usageDto = (UsageDto) o;

        if (id != null ? !id.equals(usageDto.id) : usageDto.id != null) return false;
        if (forms != null ? !forms.equals(usageDto.forms) : usageDto.forms != null) return false;
        return doses != null ? doses.equals(usageDto.doses) : usageDto.doses == null;

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
        return "UsageDto{" +
                "id=" + id +
                ", forms=" + forms +
                ", doses=" + doses +
                '}';
    }
}