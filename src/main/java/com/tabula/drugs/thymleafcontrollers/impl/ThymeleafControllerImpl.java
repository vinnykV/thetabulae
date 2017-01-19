package com.tabula.drugs.thymleafcontrollers.impl;

import com.tabula.drugs.thymleafcontrollers.api.ThymeleafController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Vladyslav_Vinnyk on 1/18/2017.
 */
@Controller
public class ThymeleafControllerImpl implements ThymeleafController {
    @Override
    @RequestMapping({"/", "index.html"})
    public String index() {
        return "index";
    }

    @Override
    @RequestMapping("/medicine.html")
    public String medicine() {
        return "medicine";
    }

    @Override
    @RequestMapping("/editMedicine.html")
    public String editMedicine() {
        return "editMedicine";
    }

    //TEMPORARY
    //TODO Delete or replace

    @Override
    @RequestMapping("/onecolumn.html")
    public String oneColumn() {
        return "onecolumn";
    }

    @Override
    @RequestMapping("/threecolumn.html")
    public String threeColumn() {
        return "threecolumn";
    }

    @Override
    @RequestMapping("/twocolumn1.html")
    public String twoColumn1() {
        return "twocolumn1";
    }

    @Override
    @RequestMapping("/twocolumn2.html")
    public String twoColumn2() {
        return "twocolumn2";
    }
}