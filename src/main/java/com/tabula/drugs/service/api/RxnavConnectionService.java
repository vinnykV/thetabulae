package com.tabula.drugs.service.api;

import com.tabula.drugs.model.Drug;

/**
 * @author Vladyslav_Vinnyk on 12/15/2016.
 */
public interface RxnavConnectionService {
    Drug getDrugByRxnormId(String rxnormId);

    Drug getDrugsByName(String name);

}
