package com.tabula.drugs.service.api;

/**
 * @author Vladyslav_Vinnyk on 12/21/2016.
 */
public interface PropertiesService {
    String getSpringDatasourceUrl();

    String getRxhostUri();

    String getInteractionApiUri();

    String getRxnormdbserviceApiUri();
}
