package com.tabula.drugs.service.api;

import com.tabula.drugs.model.diseases.Disease;

import java.util.List;
import java.util.Map;

/**
 * @author Vladyslav_Vinnyk on 12/29/2016.
 */
public interface DiseaseService {
    Disease findDisease(long id);

    List<Disease> findAllDiseases(List<Long> ids);

    Map<Long, Disease> findAllDiseasesAsMap(List<Long> ids);
}
