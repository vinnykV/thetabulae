package com.tabula.drugs.staticresourcescontrollers.api;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Vladyslav_Vinnyk on 1/18/2017.
 */
public interface WebSiteController {
    @RequestMapping(value = {"/", "index.html"}, method = RequestMethod.GET)
    String index();

    @RequestMapping(value = "/medicine.html", method = RequestMethod.GET)
    String medicine();

    @RequestMapping(value = "/medicine.html/{id}", method = RequestMethod.GET)
    String medicine(Long id, ModelMap model);

    @RequestMapping(value = "/allMedicines.html", method = RequestMethod.GET)
    String allMedicines();

    @RequestMapping(value = "/editMedicine.html", method = RequestMethod.GET)
    String editMedicine();


    //TEMPORARY
    //TODO Delete or replace

    @RequestMapping(value = "/onecolumn.html", method = RequestMethod.GET)
    String oneColumn();

    @RequestMapping(value = "/threecolumn.html", method = RequestMethod.GET)
    String threeColumn();

    @RequestMapping(value = "/twocolumn1.html", method = RequestMethod.GET)
    String twoColumn1();

    @RequestMapping(value = "/twocolumn2.html", method = RequestMethod.GET)
    String twoColumn2();
}