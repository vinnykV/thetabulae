package com.tabula.drugs.dto.medicines.dosing;

/**
 * @author Vladyslav_Vinnyk on 12/26/2016.
 */
public class DosingAndUsingDto {
    private Long id;

    private UsageDto adult;

    private UsageDto pediatric;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsageDto getAdult() {
        return adult;
    }

    public void setAdult(UsageDto adult) {
        this.adult = adult;
    }

    public UsageDto getPediatric() {
        return pediatric;
    }

    public void setPediatric(UsageDto pediatric) {
        this.pediatric = pediatric;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DosingAndUsingDto that = (DosingAndUsingDto) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (adult != null ? !adult.equals(that.adult) : that.adult != null) return false;
        return pediatric != null ? pediatric.equals(that.pediatric) : that.pediatric == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (adult != null ? adult.hashCode() : 0);
        result = 31 * result + (pediatric != null ? pediatric.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DosingAndUsingDto{" +
                "id=" + id +
                ", adult=" + adult +
                ", pediatric=" + pediatric +
                '}';
    }
}