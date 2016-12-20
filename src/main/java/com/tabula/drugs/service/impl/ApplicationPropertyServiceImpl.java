package com.tabula.drugs.service.impl;

import com.tabula.drugs.service.api.ApplicationPropertyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Vladyslav_Vinnyk on 12/20/2016.
 */
@Component
public class ApplicationPropertyServiceImpl implements ApplicationPropertyService {

    @Value("${rxnav.nlm.nih.gov.rxcui}")
    private String urlToRetrieveDrugByRxcui;

    @Value("${rxnav.nlm.nih.gov.name}")
    private String urlToRetrieveDrugByName;


    @Override
    public String getUrlToRetrieveDrugByRxcui() {
        return urlToRetrieveDrugByRxcui;
    }

    @Override
    public String getUrlToRetrieveDrugByName() {
        return urlToRetrieveDrugByName;
    }
}
