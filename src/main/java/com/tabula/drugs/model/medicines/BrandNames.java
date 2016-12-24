package com.tabula.drugs.model.medicines.dosing;

import java.util.List;

/**
 * @author Vladyslav_Vinnyk on 12/21/2016.
 */
public class BrandNames {
    private List<String> brandNames;

    public List<String> getBrandNames() {
        return brandNames;
    }

    public void setBrandNames(List<String> brandNames) {
        this.brandNames = brandNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BrandNames that = (BrandNames) o;

        return brandNames != null ? brandNames.equals(that.brandNames) : that.brandNames == null;

    }

    @Override
    public int hashCode() {
        return brandNames != null ? brandNames.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BrandNames{" +
                "brandNames=" + brandNames +
                '}';
    }
}
