package com.tabula.drugs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.stereotype.Service;

/**
 * @author Vladyslav_Vinnyk on 12/15/2016.
 */
@Service
public class PropertiesService {
    @Value("${spring.datasource.url}")
    private String springDatasourceUrl;

    public String getSpringDatasourceUrl() {
        return springDatasourceUrl;
    }

    public void setSpringDatasourceUrl(String springDatasourceUrl) {
        this.springDatasourceUrl = springDatasourceUrl;
    }
}
