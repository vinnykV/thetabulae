package com.tabula.drugs.model.medicines.pregnancy;

import com.tabula.drugs.model.medicines.Medicine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Vladyslav_Vinnyk on 12/21/2016.
 */
@Entity
public class Pregnancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "lactation", length = 1024)
    private String lactation;

    @OneToOne(mappedBy = "pregnancy")
    private Medicine medicine;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pregnancy pregnancy = (Pregnancy) o;

        if (id != null ? !id.equals(pregnancy.id) : pregnancy.id != null) return false;
        if (category != pregnancy.category) return false;
        return lactation != null ? lactation.equals(pregnancy.lactation) : pregnancy.lactation == null;

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
        return "Pregnancy{" +
                "id=" + id +
                ", category=" + category +
                ", lactation='" + lactation + '\'' +
                '}';
    }
}