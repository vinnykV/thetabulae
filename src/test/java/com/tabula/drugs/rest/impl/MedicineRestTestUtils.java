package com.tabula.drugs.rest.impl;

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

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vladyslav_Vinnyk on 1/18/2017.
 */
public class MedicineRestTestUtils {
    public static Medicine createExpectedMedicine() {
        Medicine medicine = new Medicine();
        medicine.setName("aspirin");
        medicine.setDosingAndUsing(createDosingAndUsing());
        medicine.setAdverseEffects(createAdverseEffects());
        medicine.setPregnancy(createPregnancy());
        medicine.setPharmacology(createPharmacology());

        return medicine;
    }

    public static List<AdverseEffects> createAdverseEffects() {
        List<AdverseEffects> adverseEffectsList = new ArrayList<>();

        AdverseEffects adverseEffects = new AdverseEffects();
        adverseEffects.setFrequency(Frequency.MORE_TEN);
        adverseEffects.setDescription("Angioedema\n" +
                "Bronchospasm\n" +
                "CNS alteration\n" +
                "Dermatologic problems\n" +
                "GI pain, ulceration, bleeding\n" +
                "Hepatotoxicity\n" +
                "Hearing loss\n" +
                "Nausea\n" +
                "Platelet aggregation inhibition\n" +
                "Premature hemolysis\n" +
                "Pulmonary edema (salicylate-induced, noncardiogenic)\n" +
                "Rash\n" +
                "Renal damage\n" +
                "Tinnitus\n" +
                "Urticaria\n" +
                "Vomiting");

        adverseEffectsList.add(adverseEffects);
        return adverseEffectsList;
    }

    public static DosingAndUsing createDosingAndUsing() {

        DosingAndUsing dosingAndUsing = new DosingAndUsing();
        Usage adult = createAdultUsage();
        Usage pediatrics = createPediatricsUsage();

        dosingAndUsing.setAdult(adult);
        dosingAndUsing.setPediatric(pediatrics);
        return dosingAndUsing;
    }

    public static Usage createPediatricsUsage() {
        Usage usage = new Usage();
        List<Dose> doses = createPediatricsDoses();
        Forms forms = createPediatricsForms();

        usage.addDoses(doses);
        usage.setForms(forms);

        return usage;
    }

    public static List<Dose> createPediatricsDoses() {
        List<Dose> doses = new ArrayList<>();

        doses.add(createDose("Pain & Fever", "<12 years\n" +
                "10-15 mg/kg PO q4hr, up to 60-80 mg/kg/day\n" +
                "≥12 years\n" +
                "325-650 mg PO/PR q4-6hr PRN\n" +
                "Controlled/extended/delayed-release products (enteric coated): 650-1300 mg PO q8hr; not to exceed 3.9 g/day"));

        doses.add(createDose("Kawasaki Disease", "Febrile phase: 80-100 mg/kg/day PO divided q6hr for up to 14 days (48-72 hours after fever defervescence) \n" +
                "Maintenance: 3-6 mg/kg/day PO in single dose"));
        doses.add(createDose("Dosing Considerations", "Toxic dose: 200 mg/kg"));

        return doses;
    }

    public static Usage createAdultUsage() {
        Usage usage = new Usage();
        List<Dose> doses = createAdultDoses();
        Forms forms = createAdultForms();

        usage.addDoses(doses);
        usage.setForms(forms);

        return usage;
    }

    public static List<Dose> createAdultDoses() {
        List<Dose> doses = new ArrayList<>();

        doses.add(createDose("Acute Coronary Syndrome", "For use as adjunctive antithrombotic effects for ACS (ST-segment elevation myocardial infarction [STEMI], unstable angina [UA]/non-ST-segment elevation myocardial infarction [NSTEMI])\n" +
                "Acute symptoms\n" +
                "160-325 mg PO; chew nonenteric-coated tablet upon presentation (within minutes of symptoms)\n" +
                "If unable to take PO, may give 300-600 mg suppository PR\n" +
                "Maintenance (secondary prevention)\n" +
                "75-81 mg PO qDay indefinitely (preferred dose); may give 81-325 mg/day\n" +
                "Regimen may depend on coadministered drugs or comorbid conditions\n" +
                "Coadministered with ticagrelor: 81 mg PO qDay\n" +
                "Percutaneous transluminal coronary angioplasty\n" +
                "Adjunctive aspirin therapy to support reperfusion with primary PCI (with or without fibrinolytic therapy)\n" +
                "Preoperative dose: 162-325 mg PO before procedure\n" +
                "Maintenance: 81 mg PO qDay indefinitely (preferred dose) may give 81-325 mg/day\n" +
                "Regimen may depend on coadministered drugs or comorbid conditions\n" +
                "Coadministered with ticagrelor: 81 mg PO qDay"));

        doses.add(createDose("Ischemic Stroke & Transient Ischemic Attack", "50-325 mg/day PO within 48 hours of stroke or TIA, then 75-100 mg/day PO"));


        doses.add(createDose("Rheumatoid Arthritis", "3 g/day PO in divided doses; increased PRN for anti-inflammatory efficacy (target plasma salicylate, 150-300 mcg/mL)"));

        doses.add(createDose("Spondyloarthropathy", "3.6-5.4 g/day PO in divided doses; monitor serum concentrations"));

        doses.add(createDose("Colorectal Cancer (Off-label)", "Prophylaxis\n" +
                "600 mg/day PO\n" +
                "Decreases risk of developing hereditary colorectal cancer (ie, Lynch syndrome) by 60% if taken daily for at least 2 years"));

        doses.add(createDose("Dosing Modifications", "Renal impairment\n" +
                "CrCl >10 mL/min: Dose adjustment not necessary\n" +
                "CrCl <10 mL/min: Not recommended\n" +
                "Hepatic impairment\n" +
                "Severe liver disease: Not recommended"));

        return doses;
    }

    private static Dose createDose(String disease, String description) {
        Dose dose = new Dose();
        dose.setDiseaseName(disease);
        dose.setDoseDescription(description);

        return dose;
    }

    private static Forms createAdultForms() {
        Forms forms = new Forms();

        forms.setTablet("81mg\n" +
                "325mg\n" +
                "500mg");

        return forms;
    }

    private static Forms createPediatricsForms() {
        Forms forms = new Forms();

        forms.setTablet("81mg\n" +
                "325mg\n" +
                "500mg");

        return forms;
    }

    public static Pregnancy createPregnancy() {
        Pregnancy pregnancy = new Pregnancy();
        pregnancy.setCategory(Category.C);
        pregnancy.setLactation("Drug enters breast milk; decision should be made regarding whether to discontinue nursing or to discontinue drug, taking into account importance of drug to mother.");

        return pregnancy;
    }

    public static Pharmacology createPharmacology() {
        Pharmacology pharmacology = new Pharmacology();
        pharmacology.setMechanismOfAction("Inhibits synthesis of prostaglandin by cyclooxygenase; inhibits platelet aggregation; has antipyretic and analgesic activity");
        pharmacology.setAbsorption("Bioavailability: 80-100%\n" +
                "Onset: PO, 5-30 min; PR, 1-2 hr\n" +
                "Duration: PO, 4-6 hr; PR, >7 hr\n" +
                "Peak plasma time: PO, 0.25-3 hr\n" +
                "Peak plasma concentration: Analgesia/antipyresis, 30-100 mcg/mL; anti-inflammatory, 150-300 mcg/mL");
        pharmacology.setDistribution("Protein bound: ≤100 mcg/mL, 90-95%; 100-400 mcg/mL, 70-85%; higher concentrations, 25-60%\n" +
                "Vd: 170 mL/kg");
        pharmacology.setMetabolism("Metabolized by liver via microsomal enzyme system\n" +
                "Metabolites: Salicylurate, salicyl phenolic glucuronide, salicyl acyl glucuronide, 2,5-dihydroxybenzoic acid (gentisic acid), 2,3-dihydroxybenzoic acid, 2,3,5-trihydroxybenzoic acid, gentisuric acid (active)\n" +
                "Enzymes inhibited: Cyclooxygenase (insignificant)");
        pharmacology.setElimination("Half-life: Low dose, 2-3 hr; higher dose, 15-30 hr\n" +
                "Renal clearance: 80-100% in 24-72 hr\n" +
                "Excretion: Urine (80-100%), sweat, saliva, feces\n" +
                "Dialyzable: Yes");
        return pharmacology;
    }
}
