package com.tabula.drugs.staticresourcescontrollers.api;

import com.tabula.drugs.model.user.User;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author Vladyslav_Vinnyk on 1/19/2017.
 */
public interface UserController {
    String registration(Model model);

    String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model);

    String login(Model model, String error, String logout);


}
