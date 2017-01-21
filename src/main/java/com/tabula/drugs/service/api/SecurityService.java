package com.tabula.drugs.service.api;

/**
 * @author Vladyslav_Vinnyk on 1/19/2017.
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
