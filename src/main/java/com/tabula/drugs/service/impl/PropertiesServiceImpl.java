package com.tabula.drugs.service.impl;

import com.tabula.drugs.service.api.PropertiesService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Vladyslav_Vinnyk on 12/15/2016.
 */
@Service
public class PropertiesServiceImpl implements PropertiesService {
    @Value("${spring.datasource.url}")
    private String springDatasourceUrl;

    @Value("${rxhost.uri}")
    private String rxhostUri;

    @Value("${interaction.api.uri}")
    private String interactionApiUri;

    @Value("${rxnormdbservice.api.uri}")
    private String rxnormdbserviceApiUri;

    @Override
    public String getSpringDatasourceUrl() {
        return springDatasourceUrl;
    }

    @Override
    public String getRxhostUri() {
        return rxhostUri;
    }

    @Override
    public String getInteractionApiUri() {
        return interactionApiUri;
    }

    @Override
    public String getRxnormdbserviceApiUri() {
        return rxnormdbserviceApiUri;
    }
}
