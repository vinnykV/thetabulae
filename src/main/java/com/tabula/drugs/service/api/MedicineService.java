package com.tabula.drugs.service.api;

import com.tabula.drugs.model.medicines.Medicine;

/**
 * @author Vladyslav_Vinnyk on 12/26/2016.
 */
public interface MedicineService {
    Medicine getMedicine(Long id);

    Medicine saveMedicine(Medicine medicine);
}