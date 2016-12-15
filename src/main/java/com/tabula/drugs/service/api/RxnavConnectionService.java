package com.tabula.drugs.service.api;

import com.tabula.drugs.model.Drug;

/**
 * @author Vladyslav_Vinnyk on 12/15/2016.
 */
public interface RxnavConnectionService {
    public Drug getDrugByRxnormId(String rxnormId);

    public Drug getDrugsByName(String name);

}
