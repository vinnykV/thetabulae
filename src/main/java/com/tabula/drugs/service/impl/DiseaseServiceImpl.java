package com.tabula.drugs.service.impl;

import com.google.common.collect.Lists;
import com.tabula.drugs.model.diseases.Disease;
import com.tabula.drugs.repository.DiseaseRepository;
import com.tabula.drugs.service.api.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vladyslav_Vinnyk on 12/29/2016.
 */
@Service
public class DiseaseServiceImpl implements DiseaseService {
    @Autowired
    private DiseaseRepository diseaseRepository;

    @Override
    public Disease findDisease(long id) {
        return diseaseRepository.findOne(id);
    }

    @Override
    public List<Disease> findAllDiseases(List<Long> ids) {
        Iterable<Disease> diseases = diseaseRepository.findAll(ids);
        return Lists.newArrayList(diseases);
    }

    @Override
    public Map<Long, Disease> findAllDiseasesAsMap(List<Long> ids) {
        Map<Long, Disease> diseasesMap = new HashMap<>();

        List<Disease> allDiseases = findAllDiseases(ids);
        for (Disease disease : allDiseases) {
            diseasesMap.put(disease.getId(), disease);
        }

        return diseasesMap;
    }
}
