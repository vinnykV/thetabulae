package com.tabula.drugs.dtomapper.api;

import com.tabula.drugs.dto.disease.DiseaseDto;
import com.tabula.drugs.dto.medicines.MedicineDto;
import com.tabula.drugs.dto.medicines.SimpleMedicineDto;
import com.tabula.drugs.model.diseases.Disease;
import com.tabula.drugs.model.medicines.Medicine;

import java.util.List;

/**
 * @author Vladyslav_Vinnyk on 12/29/2016.
 */
public interface DtoMapper {
    MedicineDto convertToDto(Medicine medicine);

    Medicine convertToEntity(MedicineDto medicineDto);

    DiseaseDto convertToDto(Disease disease);

    Disease convertToEntity(DiseaseDto diseaseDto);

    List<SimpleMedicineDto> convertToSimpleMedicineDto(List<Medicine> allMedicines);
}
