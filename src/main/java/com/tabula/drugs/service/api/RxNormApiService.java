package com.tabula.drugs.service.api;

import java.util.List;

/**
 * @author Vladyslav_Vinnyk on 12/21/2016.
 */
public interface RxNormApiService {
    List<String> getRxcuiByName(String drugName);
}
