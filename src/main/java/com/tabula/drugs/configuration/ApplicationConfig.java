package com.tabula.drugs.configuration;

import com.tabula.drugs.service.api.PropertiesService;
import com.tabula.drugs.utils.interactionApi.api.InteractionDBManager;
import com.tabula.drugs.utils.interactionApi.api.InteractionDBManagerService;
import com.tabula.drugs.utils.interactionApi.api.InteractionDBManagerServiceLocator;
import com.tabula.drugs.utils.rxNormApi.api.DBManager;
import com.tabula.drugs.utils.rxNormApi.api.DBManagerService;
import com.tabula.drugs.utils.rxNormApi.api.DBManagerServiceLocator;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.castor.CastorMarshaller;
import org.springframework.web.client.RestTemplate;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Vladyslav_Vinnyk on 12/14/2016.
 */
@Configuration
public class ApplicationConfig {
    @Autowired
    private PropertiesService propertiesService;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper;
    }


    @Bean
    public InteractionDBManager getInteractionDBManager() {
        String rxhostURI = propertiesService.getRxhostUri();
        String rxURI = rxhostURI + propertiesService.getInteractionApiUri();

        URL rxURL = null;
        try {
            rxURL = new URL(rxURI);
            InteractionDBManagerService interactionDBManagerService = new InteractionDBManagerServiceLocator();

            return interactionDBManagerService.getInteractionAPI(rxURL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public DBManager getRxNormDBService() {
        String rxhostURI = propertiesService.getRxhostUri();
        String rxURI = rxhostURI + propertiesService.getRxnormdbserviceApiUri();

        URL rxURL = null;
        try {
            rxURL = new URL(rxURI);
            DBManagerService rxnormService = new DBManagerServiceLocator();
            return rxnormService.getRxNormDBService(rxURL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
}
