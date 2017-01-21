package com.tabula.drugs.service.impl;

import com.tabula.drugs.service.api.RxNormApiService;
import com.tabula.drugs.utils.interactionApi.api.InteractionDBManager;
import com.tabula.drugs.utils.rxNormApi.api.DBManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vladyslav_Vinnyk on 12/21/2016.
 */
@Service
public class RxNormApiServiceImpl implements RxNormApiService {
    @Autowired
    private DBManager dbManager;

    @Autowired
    private InteractionDBManager interactionDBManager;

    @Override
    public List<String> getRxcuiByName(String drugName) {
        String[] rxcui = null;
        try {
            rxcui = dbManager.findRxcuiByString(drugName);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>(Arrays.asList(rxcui));
    }
}