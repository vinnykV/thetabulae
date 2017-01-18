package com.tabula.drugs.dtomapper.impl;

import com.tabula.drugs.TabulaDrugRestApplication;
import com.tabula.drugs.dto.medicines.MedicineDto;
import com.tabula.drugs.dtomapper.api.DtoMapper;
import com.tabula.drugs.model.diseases.Disease;
import com.tabula.drugs.model.medicines.Medicine;
import com.tabula.drugs.repository.DiseaseRepository;
import com.tabula.drugs.repository.MedicineRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static com.tabula.drugs.dtomapper.impl.DtoMapperMedicineTestUtils.createDiseases;
import static com.tabula.drugs.dtomapper.impl.DtoMapperMedicineTestUtils.createMedicineDto;
import static com.tabula.drugs.dtomapper.impl.DtoMapperMedicineTestUtils.createMedicine;

/**
 * @author Vladyslav_Vinnyk on 1/18/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TabulaDrugRestApplication.class)
@WebAppConfiguration
@ActiveProfiles("default")
@TestPropertySource(locations = "classpath:application-test.properties")
public class DtoMapperImplTest {
    @Autowired
    private DtoMapper dtoMapper;

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Autowired
    private MedicineRepository medicineRepository;

    private List<Disease> diseases;

    private Medicine medicine;

    private Medicine medicine1;

    private static final String MEDICINE_ONE_NAME = "medicine2";
    private static final String MEDICINE_TWO_NAME = "ceftriaxone";

    @Before
    public void setUp() {
        this.diseases = createDiseases();
        this.medicine1 = createMedicine(MEDICINE_ONE_NAME);
        medicine1 = medicineRepository.save(medicine1);

        medicine = createMedicine(MEDICINE_TWO_NAME);
        medicine = medicineRepository.save(medicine);
    }

    @Test
    public void shouldConvertToDtoAndBack() {
        Medicine medicine = createMedicine(MEDICINE_TWO_NAME);
        MedicineDto convertedMedicineDto = dtoMapper.convertToDto(medicine);
        Medicine backConvertedMedicine = dtoMapper.convertToEntity(convertedMedicineDto);

        Assert.assertEquals(medicine, backConvertedMedicine);
    }

    @Test
    public void shouldConvertFromDtoToEntity() {
        MedicineDto medicineDto = createMedicineDto(MEDICINE_TWO_NAME);
        Medicine expectedMedicine = createMedicine(MEDICINE_TWO_NAME);
        Medicine actualMedicine = dtoMapper.convertToEntity(medicineDto);

        Assert.assertEquals(expectedMedicine, actualMedicine);
    }

    @Test
    public void shouldConvertFromEntityToDto() {
        Medicine medicine = createMedicine(MEDICINE_TWO_NAME);
        MedicineDto expectedMedicineDto = createMedicineDto(MEDICINE_TWO_NAME);
        MedicineDto actualMedicineDto = dtoMapper.convertToDto(medicine);

        Assert.assertEquals(expectedMedicineDto, actualMedicineDto);
    }

}