package com.tabula.drugs.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tabula.drugs.dto.DrugDto;
import com.tabula.drugs.dto.InteractionConceptDto;
import com.tabula.drugs.dto.InteractionDto;
import com.tabula.drugs.service.api.InteractionCheckerService;
import com.tabula.drugs.utils.TextTranslator;
import com.tabula.drugs.utils.interactionApi.api.InteractionDBManager;
import com.tabula.drugs.utils.interactionApi.beans.FullInteractionTypeGroup;
import com.tabula.drugs.utils.rxNormApi.api.DBManager;
import com.tabula.drugs.utils.translator.api.Transliterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author Vladyslav_Vinnyk on 12/21/2016.
 */
@Service
public class InteractionCheckerServiceImpl implements InteractionCheckerService {
    @Autowired
    private InteractionDBManager interactionDBManager;

    @Autowired
    private DBManager dbManager;

    @Autowired
    private Transliterator transliterator;

    @Override
    public List<InteractionDto> getInteractions(Set<String> rxcui) {
        List<FullInteractionTypeGroup> interactionsFromList = getInteractionsFromListOfId(rxcui.toArray(new String[rxcui.size()]));
        List<InteractionDto> interactions = parse(interactionsFromList);
        translate(interactions);
        return interactions;
    }

    private void translate(List<InteractionDto> interactions) {
        for (InteractionDto interactionDto : interactions) {
            DrugDto firstDrug = interactionDto.getFirstDrug();
            DrugDto secondDrug = interactionDto.getSecondDrug();
            InteractionConceptDto interactionConceptDto = interactionDto.getInteractionConceptDto();
            String description = interactionConceptDto.getDescription();

            List<String> rusNames = translateName(firstDrug.getNames());
            firstDrug.setRusNames(rusNames);

            rusNames = translateName(secondDrug.getNames());
            secondDrug.setRusNames(rusNames);

            String rusDescription = TextTranslator.translate(description);
            interactionConceptDto.setDescription(rusDescription);
        }
    }

    private List<String> translateName(List<String> engNames) {
        List<String> rusNames = new ArrayList<>();
        for (String engName : engNames) {
            String rusName = transliterator.transliterate(engName);
            rusNames.add(rusName);
        }

        return rusNames;
    }

    private List<FullInteractionTypeGroup> getInteractionsFromListOfId(String[] ids) {
        try {
            String[] interactionSources = interactionDBManager.getInteractionSources();
            FullInteractionTypeGroup[] interactionsFromList = interactionDBManager.findInteractionsFromList(ids, interactionSources);
            return new ArrayList<>(Arrays.asList(interactionsFromList));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    private List<InteractionDto> parse(List<FullInteractionTypeGroup> interactionsFromList) {
        List<InteractionDto> interactionDtoList = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonInString = objectMapper.writeValueAsString(interactionsFromList);
            JsonNode node = objectMapper.readValue(jsonInString, JsonNode.class);

            for (int i = 0; i < node.size(); i++) {
                JsonNode interactionPairNode = node.get(i).get("fullInteractionType").get(0).get("interactionPair");

                JsonNode descriptionNode = interactionPairNode.get(0).get("description").get("content");
                JsonNode severityNode = interactionPairNode.get(0).get("severity");
                JsonNode minConceptNode = interactionPairNode.get(0).get("interactionConcept");
                JsonNode minConceptFirstDrugNode = minConceptNode.get(0).get("minConceptItem");
                JsonNode minConceptSecondDrugNode = minConceptNode.get(1).get("minConceptItem");

                String description = descriptionNode.asText();
                String severity = severityNode.get("content").asText();

                String drug1Name = minConceptFirstDrugNode.get("name").get("content").asText();
                String drug1Rxcui = minConceptFirstDrugNode.get("rxcui").get("content").asText();
                DrugDto drug1Dto = new DrugDto();
                drug1Dto.addName(drug1Name);
                drug1Dto.setRxcui(drug1Rxcui);

                String drug2Name = minConceptSecondDrugNode.get("name").get("content").asText();
                String drug2Rxcui = minConceptSecondDrugNode.get("rxcui").get("content").asText();
                DrugDto drug2Dto = new DrugDto();
                drug2Dto.addName(drug2Name);
                drug2Dto.setRxcui(drug2Rxcui);

                InteractionConceptDto interactionConceptDto = new InteractionConceptDto();
                interactionConceptDto.setDescription(description);
                interactionConceptDto.setSeverity(severity);

                InteractionDto interactionDto = new InteractionDto();
                interactionDto.setFirstDrug(drug1Dto);
                interactionDto.setSecondDrug(drug2Dto);
                interactionDto.setInteractionConceptDto(interactionConceptDto);

                interactionDtoList.add(interactionDto);
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return interactionDtoList;
    }

}
