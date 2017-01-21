package com.tabula.drugs.staticresourcescontrollers.impl;

import com.tabula.drugs.staticresourcescontrollers.api.WebSiteController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Vladyslav_Vinnyk on 1/18/2017.
 */
@Controller
public class WebSiteControllerImpl implements WebSiteController {
    @Override
    @RequestMapping(value = {"/", "index.html"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @Override
    @RequestMapping(value = "/medicine.html", method = RequestMethod.GET)
    public String medicine() {
        return "medicine";
    }

    @Override
    @RequestMapping(value = "/medicine.html/{id}", method = RequestMethod.GET)
    public String medicine(@PathVariable Long id, ModelMap model) {
        model.addAttribute("medicineId", id);
        return "medicine";
    }

    @Override
    @RequestMapping(value = "/allMedicines.html", method = RequestMethod.GET)
    public String allMedicines() {
        return "allMedicines";
    }

    @Override
    @RequestMapping(value = "/editMedicine.html", method = RequestMethod.GET)
    public String editMedicine() {
        return "editMedicine";
    }

    //TEMPORARY
    //TODO Delete or replace

    @Override
    @RequestMapping(value = "/onecolumn.html", method = RequestMethod.GET)
    public String oneColumn() {
        return "onecolumn";
    }

    @Override
    @RequestMapping(value = "/threecolumn.html", method = RequestMethod.GET)
    public String threeColumn() {
        return "threecolumn";
    }

    @Override
    @RequestMapping(value = "/twocolumn1.html", method = RequestMethod.GET)
    public String twoColumn1() {
        return "twocolumn1";
    }

    @Override
    @RequestMapping(value = "/twocolumn2.html", method = RequestMethod.GET)
    public String twoColumn2() {
        return "twocolumn2";
    }
}