package com.tabula.drugs;

import com.google.common.collect.Lists;
import com.tabula.drugs.model.medicines.Medicine;
import com.tabula.drugs.model.medicines.dosing.Dose;
import com.tabula.drugs.model.medicines.dosing.DosingAndUsing;
import com.tabula.drugs.model.medicines.dosing.Forms;
import com.tabula.drugs.model.medicines.dosing.Usage;
import com.tabula.drugs.repository.DoseRepository;
import com.tabula.drugs.repository.DosingAndUsingRepository;
import com.tabula.drugs.repository.FormsRepository;
import com.tabula.drugs.repository.MedicineRepository;
import com.tabula.drugs.repository.UsageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vladyslav_Vinnyk on 12/21/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TabulaDrugRestApplication.class)
@WebAppConfiguration
@ActiveProfiles("default")
@TestPropertySource(locations = "classpath:applicationTestRealDB.properties")
@Transactional
public class RunTest {

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private DosingAndUsingRepository dosingAndUsingRepository;

    @Autowired
    private UsageRepository usageRepository;

    @Autowired
    private DoseRepository doseRepository;

    @Autowired
    private FormsRepository formsRepository;

    @Test
    public void runIt() {
        Medicine medicine = createMedicine();
        medicine = medicineRepository.save(medicine);

        System.out.println(medicine);
    }

    private Medicine createMedicine() {
        Medicine medicine = new Medicine();
        medicine.setName("ceftriaxone");

        DosingAndUsing dosingAndUsing = new DosingAndUsing();
        Usage adult = createUsage();
        Usage pediatrics = createUsage();

        dosingAndUsing.setAdult(adult);
        dosingAndUsing.setPediatric(pediatrics);
        dosingAndUsingRepository.save(dosingAndUsing);

        medicine.setDosingAndUsing(dosingAndUsing);

        return medicine;
    }

    private Usage createUsage() {
        Usage usage = new Usage();
        List<Dose> doses = createDoses();
        Forms forms = createForms();

        usage.setDoses(doses);
        usage.setForms(forms);

        usage = usageRepository.save(usage);

        return usage;
    }

    private List<Dose> createDoses() {
        List<Dose> doses = new ArrayList<>();

        Dose dose = new Dose();

        dose.setDiseaseName("Intra-abdominal Infections");
        dose.setDoseDiscription("Complicated, mild-to-moderate, community acquired: \n" +
                "\t\t1-2 g/day IV in single daily dose or divided q12hr for 4-7\n" +
                "\t\tdays, in combination with metronidazole");

        Dose dose2 = new Dose();

        dose2.setDiseaseName("Acute Bacterial Otitis Media");
        dose2.setDoseDiscription("50 mg/kg IM once\n" +
                "\t\tPersistent or treatment failures: 50 mg/kg IV/IM for 3 days");

        Dose dose3 = new Dose();

        dose3.setDiseaseName("Pelvic Inflammatory Disease");
        dose3.setDoseDiscription(" IM as single dose with doxycycline, with or without metonidazole for 14 days");

        doses.add(dose);
        doses.add(dose2);
        doses.add(dose3);
        doses = Lists.newArrayList(doseRepository.save(doses));
        return doses;
    }

    private Forms createForms() {
        Forms forms = new Forms();

        forms.setInjectable("1g/50mL,2g/50mL");
        forms.setPowderForInjections("250mg,500mg,1g,2g,10g,100g");

        forms = formsRepository.save(forms);

        return forms;
    }
}
