package com.tabula.drugs;

import com.tabula.drugs.repository.MedicineRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author Vladyslav_Vinnyk on 12/25/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TabulaDrugRestApplication.class)
@WebAppConfiguration
@ActiveProfiles("default")
@TestPropertySource(locations = "classpath:applicationTestRealDB.properties")
public class Run2 {
    @Autowired
    private MedicineRepository medicineRepository;

    @Test
    public void setUp() {
        System.out.println(medicineRepository.findAll());
    }
}