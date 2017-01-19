package com.tabula.drugs.thymleafcontrollers.api;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Vladyslav_Vinnyk on 1/18/2017.
 */
public interface ThymeleafController {
    @RequestMapping({"/", "index.html"})
    String index();

    @RequestMapping("/medicine.html")
    String medicine();

    @RequestMapping("/editMedicine.html")
    String editMedicine();


    //TEMPORARY
    //TODO Delete or replace

    @RequestMapping("/onecolumn.html")
    String oneColumn();

    @RequestMapping("/threecolumn.html")
    String threeColumn();

    @RequestMapping("/twocolumn1.html")
    String twoColumn1();

    @RequestMapping("/twocolumn2.html")
    String twoColumn2();
}