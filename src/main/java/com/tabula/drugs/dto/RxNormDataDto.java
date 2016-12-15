package com.tabula.drugs.dto;

/**
 * @author Vladyslav_Vinnyk on 12/15/2016.
 */
public class RxNormDataDto {
    private IdGroup idGroup;

    public IdGroup getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(IdGroup idGroup) {
        this.idGroup = idGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RxNormDataDto that = (RxNormDataDto) o;

        return idGroup != null ? idGroup.equals(that.idGroup) : that.idGroup == null;

    }

    @Override
    public int hashCode() {
        return idGroup != null ? idGroup.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "RxNormDataDto{" +
                "idGroupl=" + idGroup +
                '}';
    }
}
