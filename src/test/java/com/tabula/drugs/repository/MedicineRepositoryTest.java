package com.tabula.drugs.repository;

import com.tabula.drugs.TabulaDrugRestApplication;
import com.tabula.drugs.model.medicines.Medicine;
import com.tabula.drugs.rest.impl.MedicineRestTestUtils;
import com.tabula.drugs.service.api.MedicineService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * @author Vladyslav_Vinnyk on 1/18/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TabulaDrugRestApplication.class)
@WebAppConfiguration
@ActiveProfiles("default")
@TestPropertySource(locations = "classpath:applicationTestRealDB.properties")
public class MedicineRepositoryTest {
    @Autowired
    private MedicineRepository medicineRepository;

    @Test
    public void shouldSaveMedicineInRepository() {
        Medicine expectedMedicine = MedicineRestTestUtils.createExpectedMedicine();

        Medicine saveMedicineRepository = medicineRepository.save(expectedMedicine);

        assertEquals(expectedMedicine, saveMedicineRepository);
    }
}