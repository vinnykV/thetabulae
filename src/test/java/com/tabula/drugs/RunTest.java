package com.tabula.drugs;

import com.tabula.drugs.model.diseases.Disease;
import com.tabula.drugs.model.medicines.Medicine;
import com.tabula.drugs.repository.DiseaseRepository;
import com.tabula.drugs.repository.MedicineRepository;
import org.junit.Before;
import org.junit.Ignore;
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
import static com.tabula.drugs.dtomapper.impl.DtoMapperMedicineTestUtils.createMedicine;

/**
 * @author Vladyslav_Vinnyk on 12/21/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TabulaDrugRestApplication.class)
@WebAppConfiguration
@ActiveProfiles("default")
@TestPropertySource(locations = "classpath:applicationTestRealDB.properties")
public class RunTest {

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private DiseaseRepository diseaseRepository;

    private List<Disease> diseases;

    private Medicine medicine;

    private Medicine medicine1;

    @Before
    public void setUp() {
        this.diseases = createDiseases();
        this.medicine1 = createMedicine("medicine2");
        medicine1 = medicineRepository.save(medicine1);

        medicine = createMedicine("ceftriaxone");
        medicine = medicineRepository.save(medicine);
    }

    @Test
    @Ignore
    public void runIt() {
    }

//    private Interaction createInteraction() {
//
//        Interaction interaction = new Interaction();
//        interaction.setSecondMedicineId(medicine1.getId());
//        interaction.setSeverity(InteractionSeverity.SERIOUS);
//        interaction.setDescription("calcium acetate");
//
//        return interaction;
//    }
}