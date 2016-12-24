package com.tabula.drugs.rest.impl;

import com.tabula.drugs.dto.InteractionDto;
import com.tabula.drugs.rest.api.DrugInteractionRestController;
import com.tabula.drugs.service.api.InteractionCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * @author Vladyslav_Vinnyk on 12/21/2016.
 */
@RestController
public class DrugInteractionRestControllerImpl implements DrugInteractionRestController {
    @Autowired
    private InteractionCheckerService interactionCheckerService;

    @Override
    public List<InteractionDto> searchInteraction(@RequestParam Set<String> rxcui) {
        return interactionCheckerService.getInteractions(rxcui);
    }
}
