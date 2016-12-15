package com.tabula.drugs.rest;

import com.tabula.drugs.repository.DrugRepository;
import com.tabula.drugs.service.PropertiesService;
import com.tabula.drugs.service.api.RxnavConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vladyslav_Vinnyk on 12/14/2016.
 */
@RestController
public class DrugRestController {
    @Autowired
    private RxnavConnectionService rxnavConnectionService;

    @RequestMapping("/name")
    public String index() {
        return rxnavConnectionService.getDrugsByName("").toString();
    }

    @RequestMapping("/rxnormId")
    public String index2() {
        return rxnavConnectionService.getDrugByRxnormId("").toString();
    }

}
