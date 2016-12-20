package com.tabula.drugs.rest.impl;

import com.tabula.drugs.model.Drug;
import com.tabula.drugs.repository.DrugRepository;
import com.tabula.drugs.rest.api.DrugRestController;
import com.tabula.drugs.service.PropertiesService;
import com.tabula.drugs.service.api.RxnavConnectionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vladyslav_Vinnyk on 12/14/2016.
 */
@RestController
public class DrugRestControllerImpl implements DrugRestController{
    @Autowired
    private RxnavConnectionService rxnavConnectionService;

    @Override
    public Drug name(@PathVariable("name") String name) {
        return rxnavConnectionService.getDrugsByName(name);
    }

    @Override
    public Drug rxnormId(@PathVariable("rxnormId") String rxnormId) {
        return rxnavConnectionService.getDrugByRxnormId(rxnormId);
    }

}
