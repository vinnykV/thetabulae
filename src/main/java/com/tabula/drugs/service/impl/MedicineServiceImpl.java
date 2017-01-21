package com.tabula.drugs.service.impl;

import com.google.common.collect.Lists;
import com.tabula.drugs.model.medicines.Medicine;
import com.tabula.drugs.repository.MedicineRepository;
import com.tabula.drugs.service.api.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Vinnyk on 12/26/2016.
 */
@Service
public class MedicineServiceImpl implements MedicineService {
    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public Medicine getMedicine(Long id) {
        return medicineRepository.findOne(id);
    }

    @Override
    public Medicine saveMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @Override
    public List<Medicine> getAllMedicines() {
        return Lists.newArrayList(medicineRepository.findAll());
    }
}