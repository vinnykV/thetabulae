package com.tabula.drugs.dto.medicines.pregnancy;

import com.tabula.drugs.model.medicines.pregnancy.Category;
import com.tabula.drugs.model.medicines.pregnancy.Pregnancy;

/**
 * @author Vladyslav_Vinnyk on 12/26/2016.
 */
public class PregnancyDto {
    private Long id;

    private Category category;

    private String lactation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getLactation() {
        return lactation;
    }

    public void setLactation(String lactation) {
        this.lactation = lactation;
    }

    public Pregnancy convertToPregnancy() {
        Pregnancy pregnancy = new Pregnancy();

        pregnancy.setId(id);
        pregnancy.setCategory(category);
        pregnancy.setLactation(lactation);

        return pregnancy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PregnancyDto that = (PregnancyDto) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (category != that.category) return false;
        return lactation != null ? lactation.equals(that.lactation) : that.lactation == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (lactation != null ? lactation.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PregnancyDto{" +
                "id=" + id +
                ", category=" + category +
                ", lactation='" + lactation + '\'' +
                '}';
    }
}
