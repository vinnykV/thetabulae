package com.tabula.drugs.dtomapper.impl;

import com.tabula.drugs.dto.disease.DiseaseDto;
import com.tabula.drugs.dto.medicines.MedicineDto;
import com.tabula.drugs.dto.medicines.SimpleMedicineDto;
import com.tabula.drugs.dtomapper.api.DtoMapper;
import com.tabula.drugs.model.diseases.Disease;
import com.tabula.drugs.model.medicines.Medicine;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vladyslav_Vinnyk on 12/29/2016.
 */
@Service
public class DtoMapperImpl implements DtoMapper {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MedicineDto convertToDto(Medicine medicine) {
        MedicineDto medicineDto = modelMapper.map(medicine, MedicineDto.class);
        return medicineDto;
    }

    @Override
    public Medicine convertToEntity(MedicineDto medicineDto) {
        return medicineDto.convertToMedicine();
    }

    @Override
    public DiseaseDto convertToDto(Disease disease) {
        DiseaseDto diseaseDto = modelMapper.map(disease, DiseaseDto.class);
        return diseaseDto;
    }

    @Override
    public Disease convertToEntity(DiseaseDto diseaseDto) {
        Disease disease = modelMapper.map(diseaseDto, Disease.class);
        return disease;
    }

    @Override
    public List<SimpleMedicineDto> convertToSimpleMedicineDto(List<Medicine> allMedicines) {
        List<SimpleMedicineDto> simpleMedicineDtos = new ArrayList<>();

        for (Medicine medicine : allMedicines) {
            SimpleMedicineDto simpleMedicineDto = modelMapper.map(medicine, SimpleMedicineDto.class);
            simpleMedicineDtos.add(simpleMedicineDto);
        }

        return simpleMedicineDtos;
    }
}