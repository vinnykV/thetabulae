package com.tabula.drugs.dto;

/**
 * Created by Vladyslav_Vinnyk on 12/29/2016.
 */
public class TryDto {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TryDto tryDto = (TryDto) o;

        return name != null ? name.equals(tryDto.name) : tryDto.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "TryDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
