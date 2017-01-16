package com.tabula.drugs.dtomapper.api;

import com.tabula.drugs.dto.disease.DiseaseDto;
import com.tabula.drugs.dto.medicines.MedicineDto;
import com.tabula.drugs.model.diseases.Disease;
import com.tabula.drugs.model.medicines.Medicine;

/**
 * @author Vladyslav_Vinnyk on 12/29/2016.
 */
public interface DtoMapper {
    MedicineDto convertToDto(Medicine medicine);

    Medicine convertToEntity(MedicineDto medicineDto);

    DiseaseDto convertToDto(Disease disease);

    Disease convertToEntity(DiseaseDto diseaseDto);
}
