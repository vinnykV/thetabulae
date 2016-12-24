package com.tabula.drugs.dto;

/**
 * @author Vladyslav_Vinnyk on 12/21/2016.
 */
public class InteractionDto {
    private DrugDto firstDrug;

    private DrugDto secondDrug;

    private InteractionConceptDto interactionConceptDtoMap;

    public InteractionDto(DrugDto firstDrug, DrugDto secondDrug, InteractionConceptDto interactionConceptDtoMap) {
        this.firstDrug = firstDrug;
        this.secondDrug = secondDrug;
        this.interactionConceptDtoMap = interactionConceptDtoMap;
    }

    public InteractionDto() {

    }

    public DrugDto getFirstDrug() {
        return firstDrug;
    }

    public void setFirstDrug(DrugDto firstDrug) {
        this.firstDrug = firstDrug;
    }

    public DrugDto getSecondDrug() {
        return secondDrug;
    }

    public void setSecondDrug(DrugDto secondDrug) {
        this.secondDrug = secondDrug;
    }

    public InteractionConceptDto getInteractionConceptDto() {
        return interactionConceptDtoMap;
    }

    public void setInteractionConceptDto(InteractionConceptDto interactionConceptDtoMap) {
        this.interactionConceptDtoMap = interactionConceptDtoMap;
    }

    @Override
    public String toString() {
        return "InteractionDto{" +
                "firstDrug=" + firstDrug +
                ", secondDrug=" + secondDrug +
                ", interactionConceptDtoMap=" + interactionConceptDtoMap +
                '}';
    }
}
