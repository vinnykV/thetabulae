package com.tabula.drugs.dtomapper.impl;

import com.tabula.drugs.dto.disease.DiseaseDto;
import com.tabula.drugs.dto.medicines.MedicineDto;
import com.tabula.drugs.dto.medicines.dosing.DoseDto;
import com.tabula.drugs.dtomapper.api.DtoMapper;
import com.tabula.drugs.model.diseases.Disease;
import com.tabula.drugs.model.medicines.Medicine;
import com.tabula.drugs.model.medicines.dosing.Dose;
import com.tabula.drugs.service.api.DiseaseService;
import com.tabula.drugs.utils.asserter.Assert;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Vladyslav_Vinnyk on 12/29/2016.
 */
@Service
public class DtoMapperImpl implements DtoMapper {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DiseaseService diseaseService;

    @Override
    public MedicineDto convertToDto(Medicine medicine) {
        MedicineDto medicineDto = modelMapper.map(medicine, MedicineDto.class);
        replaceDiseaseIdsToDiseaseNames(medicineDto, medicine);
        return medicineDto;
    }

    private void replaceDiseaseIdsToDiseaseNames(MedicineDto medicineDto, Medicine medicine) {
        List<Dose> adultDoses = getAdultDoses(medicine);
        List<Dose> pediatricDoses = getPediatricDoses(medicine);

        List<DoseDto> adultDtoDoses = medicineDto.getDosingAndUsing().getAdult().getDoses();
        List<DoseDto> pediatricDtoDoses = medicineDto.getDosingAndUsing().getPediatric().getDoses();

        Map<Long, Disease> allNeededDisease = getAllNeededDisease(adultDoses, pediatricDoses);

        replaceDiseaseIdByName(adultDoses, adultDtoDoses, allNeededDisease);
        replaceDiseaseIdByName(pediatricDoses, pediatricDtoDoses, allNeededDisease);
    }

    private void replaceDiseaseIdByName(List<Dose> doses, List<DoseDto> dosesDto, Map<Long, Disease> allNeededDisease) {
        for (Dose adultDose : doses) {
            Long id = adultDose.getId();
            Long diseaseId = adultDose.getDiseaseId();
            Disease disease = allNeededDisease.get(diseaseId);
            DoseDto doseDto = getDoseDto(id, dosesDto);

            if (doseDto != null) {
                doseDto.setDiseaseName(disease.getName());
            }
        }
    }

    private DoseDto getDoseDto(Long id, List<DoseDto> doseDtos) {
        for (DoseDto doseDto : doseDtos) {
            if (doseDto.getId() == id) {
                return doseDto;
            }
        }
        return null;
    }

    @Override
    public Medicine convertToEntity(MedicineDto medicineDto) {
        Medicine medicine = modelMapper.map(medicineDto, Medicine.class);
        return medicine;
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

    private Map<Long, Disease> getAllNeededDisease(List<Dose> adultDoses, List<Dose> pediatricDoses) {
        Set<Long> diseasesIds = adultDoses.stream()
                .map(Dose::getDiseaseId).collect(Collectors.toSet());
        diseasesIds.addAll(pediatricDoses.stream()
                .map(Dose::getDiseaseId).collect(Collectors.toSet()));

        return diseaseService.findAllDiseasesAsMap(new ArrayList<>(diseasesIds));
    }

    private List<Dose> getAdultDoses(Medicine medicine) {
        Assert.assertAdultDosesNotNull(medicine);
        return medicine.getDosingAndUsing().getAdult().getDoses();
    }

    private List<Dose> getPediatricDoses(Medicine medicine) {
        Assert.assertPediatricDosesNotNull(medicine);
        return medicine.getDosingAndUsing().getPediatric().getDoses();
    }

}
