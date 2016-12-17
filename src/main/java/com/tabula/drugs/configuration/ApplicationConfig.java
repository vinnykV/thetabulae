package com.tabula.drugs.configuration;

import com.tabula.drugs.utils.XmlConverter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.castor.CastorMarshaller;
import org.springframework.web.client.RestTemplate;

/**
 * @author Vladyslav_Vinnyk on 12/14/2016.
 */
@Configuration
public class ApplicationConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public XmlConverter getHandler() {
        XmlConverter handler = new XmlConverter();
        handler.setMarshaller(getCastorMarshaller());
        handler.setUnmarshaller(getCastorMarshaller());
        return handler;
    }

    @Bean
    public CastorMarshaller getCastorMarshaller() {
        CastorMarshaller castorMarshaller = new CastorMarshaller();
        //TODO Trailing String
        Resource resource = new ClassPathResource("oxm/mapping.xml");
        castorMarshaller.setMappingLocation(resource);
        return castorMarshaller;
    }
}
