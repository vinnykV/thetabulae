package com.tabula.drugs.service.api;

import com.tabula.drugs.dto.InteractionDto;

import java.util.List;
import java.util.Set;

/**
 * @author Vladyslav_Vinnyk on 12/21/2016.
 */
public interface InteractionCheckerService {
    List<InteractionDto> getInteractions(Set<String> rxcui);
}
