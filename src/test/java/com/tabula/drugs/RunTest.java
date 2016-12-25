package com.tabula.drugs;

import com.google.common.collect.Lists;
import com.tabula.drugs.model.diseases.Disease;
import com.tabula.drugs.model.medicines.Medicine;
import com.tabula.drugs.model.medicines.adverseEffects.AdverseEffects;
import com.tabula.drugs.model.medicines.adverseEffects.Frequency;
import com.tabula.drugs.model.medicines.dosing.Dose;
import com.tabula.drugs.model.medicines.dosing.DosingAndUsing;
import com.tabula.drugs.model.medicines.dosing.Forms;
import com.tabula.drugs.model.medicines.dosing.Usage;
import com.tabula.drugs.model.medicines.pharmacology.Pharmacology;
import com.tabula.drugs.model.medicines.pregnancy.Category;
import com.tabula.drugs.model.medicines.pregnancy.Pregnancy;
import com.tabula.drugs.repository.DiseaseRepository;
import com.tabula.drugs.repository.MedicineRepository;
import liquibase.integration.spring.SpringLiquibase;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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
public class RunTest {

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private DiseaseRepository diseaseRepository;

    private List<Disease> diseases;

    private Medicine medicine;

    private Medicine medicine1;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SpringLiquibase springLiquibase;

    @Before
    public void setUp() {
        System.out.println(dataSource);
        this.diseases = createDiseases();
        this.medicine1 = new Medicine();
        medicine1.setName("MedicineName2");
        medicine1.setDosingAndUsing(createDosingAndUsing());
        medicine1.setAdverseEffects(createAdverseEffects());
        medicine1.setPregnancy(createPregnancy());
        medicine1.setPharmacology(createPharmacology());
        medicine1 = medicineRepository.save(medicine1);

        medicine = new Medicine();
        medicine.setName("ceftriaxone");
        medicine.setDosingAndUsing(createDosingAndUsing());
        medicine.setAdverseEffects(createAdverseEffects());
        medicine.setPregnancy(createPregnancy());
        medicine.setPharmacology(createPharmacology());
        medicine = medicineRepository.save(medicine);
    }

    @Test
    public void runIt() {
//        System.out.println(medicine);
//        System.out.println(medicine2);
    }

    private DosingAndUsing createDosingAndUsing() {

        DosingAndUsing dosingAndUsing = new DosingAndUsing();
        Usage adult = createUsage();
        Usage pediatrics = createUsage();

        dosingAndUsing.setAdult(adult);
        dosingAndUsing.setPediatric(pediatrics);
        return dosingAndUsing;
    }

    private Usage createUsage() {
        Usage usage = new Usage();
        List<Dose> doses = createDoses();
        Forms forms = createForms();

        usage.addDoses(doses);
        usage.setForms(forms);

        return usage;
    }

    private List<Dose> createDoses() {
        List<Dose> doses = new ArrayList<>();

        Dose dose = new Dose();

        dose.setDiseaseId(diseases.get(0).getId());
        dose.setDoseDescription("Complicated, mild-to-moderate, community acquired: \n" +
                "\t\t1-2 g/day IV in single daily dose or divided q12hr for 4-7\n" +
                "\t\tdays, in combination with metronidazole");

        Dose dose2 = new Dose();

        dose2.setDiseaseId(diseases.get(1).getId());
        dose2.setDoseDescription("50 mg/kg IM once\n" +
                "\t\tPersistent or treatment failures: 50 mg/kg IV/IM for 3 days");

        Dose dose3 = new Dose();

        dose3.setDiseaseId(diseases.get(2).getId());
        dose3.setDoseDescription(" IM as single dose with doxycycline, with or without metonidazole for 14 days");

        doses.add(dose);
        doses.add(dose2);
        doses.add(dose3);
        return doses;
    }

    private Forms createForms() {
        Forms forms = new Forms();

        forms.setInjectable("1g/50mL,2g/50mL");
        forms.setPowderForInjections("250mg,500mg,1g,2g,10g,100g");

        return forms;
    }

    private List<Disease> createDiseases() {
        List<Disease> diseases = new ArrayList<>();
        Disease disease = new Disease();
        disease.setName("Intra-abdominal Infections");
        Disease disease2 = new Disease();
        disease2.setName("Acute Bacterial Otitis Media");
        Disease disease3 = new Disease();
        disease3.setName("Pelvic Inflammatory Disease");

        diseases.add(disease);
        diseases.add(disease2);
        diseases.add(disease3);

        return Lists.newArrayList(diseaseRepository.save(diseases));
    }

    private List<AdverseEffects> createAdverseEffects() {
        List<AdverseEffects> adverseEffectsList = new ArrayList<>();

        AdverseEffects adverseEffects = new AdverseEffects();
        adverseEffects.setFrequency(Frequency.MORE_TEN);
        adverseEffects.setDescription("Induration after IM injection (5-17%)");

        adverseEffectsList.add(adverseEffects);
        return adverseEffectsList;
    }

    private Pregnancy createPregnancy() {
        Pregnancy pregnancy = new Pregnancy();
        pregnancy.setCategory(Category.B);
        pregnancy.setLactation("Drug enters breast milk in low concentrations; use with caution");

        return pregnancy;
    }

    private Pharmacology createPharmacology() {
        Pharmacology pharmacology = new Pharmacology();
        pharmacology.setMechanismOfAction("Third-generation cephalosporin with broad-spectrum" +
                " gram-negative activity; has lower efficacy against gram-positive organisms " +
                "but higher efficacy against resistant organisms; highly stable in presence of" +
                " beta-lactamases (penicillinase and cephalosporinase) of gram-negative and" +
                " gram-positive bacteria; bactericidal activity results from inhibiting cell-wall" +
                " synthesis by binding to 1 or more penicillin-binding proteins; " +
                "exerts antimicrobial effect by interfering with synthesis of peptidoglycan " +
                "(major structural component of bacterial cell wall); bacteria eventually " +
                "lyse because activity of cell-wall autolytic enzymes continues while cell-wall" +
                " assembly is arrested");
        pharmacology.setAbsorption("IM preparation well absorbed\n" +
                "Peak plasma time: 2-3 hr (IM)");
        pharmacology.setDistribution("Distributed throughout body, including gallbladder, lungs," +
                " bone, bile, and CSF (higher concentrations achieved when meninges are inflamed); crosses placenta; enters amniotic fluid and breast milk\n" +
                "Protein bound: 85-95%\n" +
                "Vd: 6-14 L");
        pharmacology.setMetabolism("Metabolized in liver");
        pharmacology.setElimination("Half-life: 5-9 hr (normal hepatic and renal function); 12-16 hr (mild-to-severe renal impairment)\n" +
                "Excretion: Urine (33-67% as unchanged drug), feces");
        return pharmacology;
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