package com.tabula.drugs.dto;

/**
 * @author Vladyslav_Vinnyk on 12/21/2016.
 */
public class InteractionConceptDto {
    private String description;

    private String severity;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    @Override
    public String toString() {
        return "InteractionConceptDto{" +
                "description='" + description + '\'' +
                ", severity='" + severity + '\'' +
                '}';
    }
}
