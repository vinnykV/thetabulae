package com.tabula.drugs.service.api;

import com.tabula.drugs.model.user.User;

/**
 * @author Vladyslav_Vinnyk on 1/19/2017.
 */
public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
