package com.tabula.drugs.dtomapper.impl;

import com.google.common.collect.Lists;
import com.tabula.drugs.dto.medicines.MedicineDto;
import com.tabula.drugs.dto.medicines.adverseeffect.AdverseEffectsDto;
import com.tabula.drugs.dto.medicines.dosing.DoseDto;
import com.tabula.drugs.dto.medicines.dosing.DosingAndUsingDto;
import com.tabula.drugs.dto.medicines.dosing.FormsDto;
import com.tabula.drugs.dto.medicines.dosing.UsageDto;
import com.tabula.drugs.dto.medicines.pharmacology.PharmacologyDto;
import com.tabula.drugs.dto.medicines.pregnancy.PregnancyDto;
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

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vladyslav_Vinnyk on 1/18/2017.
 */
public class DtoMapperMedicineTestUtils {

    public static MedicineDto createMedicineDto(String drugName) {
        MedicineDto medicineDto = new MedicineDto();
        medicineDto.setName(drugName);
        medicineDto.setDosingAndUsing(createDosingAndUsingDto());
        medicineDto.setAdverseEffects(createAdverseEffectsDto());
        medicineDto.setPregnancy(createPregnancyDto());
        medicineDto.setPharmacology(createPharmacologyDto());

        return medicineDto;
    }

    public static Medicine createMedicine(String drugName) {
        Medicine medicine = new Medicine();
        medicine.setName(drugName);
        medicine.setDosingAndUsing(createDosingAndUsing());
        medicine.setAdverseEffects(createAdverseEffects());
        medicine.setPregnancy(createPregnancy());
        medicine.setPharmacology(createPharmacology());

        return medicine;
    }

    public static Pharmacology createPharmacology() {
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


    public static Pregnancy createPregnancy() {
        Pregnancy pregnancy = new Pregnancy();
        pregnancy.setCategory(Category.B);
        pregnancy.setLactation("Drug enters breast milk in low concentrations; use with caution");

        return pregnancy;
    }

    public static List<AdverseEffects> createAdverseEffects() {
        List<AdverseEffects> adverseEffectsList = new ArrayList<>();

        AdverseEffects adverseEffects = new AdverseEffects();
        adverseEffects.setFrequency(Frequency.MORE_TEN);
        adverseEffects.setDescription("Induration after IM injection (5-17%)");

        adverseEffectsList.add(adverseEffects);
        return adverseEffectsList;
    }


    public static List<Disease> createDiseases() {
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

        return Lists.newArrayList(diseases);
    }

    public static Forms createForms() {
        Forms forms = new Forms();

        forms.setInjectable("1g/50mL,2g/50mL");
        forms.setPowderForInjections("250mg,500mg,1g,2g,10g,100g");

        return forms;
    }

    public static List<Dose> createDoses() {
        List<Disease> diseases = createDiseases();
        List<Dose> doses = new ArrayList<>();

        Dose dose = new Dose();

        dose.setDiseaseName(diseases.get(0).getName());
        dose.setDoseDescription("Complicated, mild-to-moderate, community acquired: \n" +
                "\t\t1-2 g/day IV in single daily dose or divided q12hr for 4-7\n" +
                "\t\tdays, in combination with metronidazole");

        Dose dose2 = new Dose();

        dose2.setDiseaseName(diseases.get(1).getName());
        dose2.setDoseDescription("50 mg/kg IM once\n" +
                "\t\tPersistent or treatment failures: 50 mg/kg IV/IM for 3 days");

        Dose dose3 = new Dose();

        dose3.setDiseaseName(diseases.get(2).getName());
        dose3.setDoseDescription(" IM as single dose with doxycycline, with or without metonidazole for 14 days");

        doses.add(dose);
        doses.add(dose2);
        doses.add(dose3);
        return doses;
    }

    public static DosingAndUsing createDosingAndUsing() {

        DosingAndUsing dosingAndUsing = new DosingAndUsing();
        Usage adult = createUsage();
        Usage pediatrics = createUsage();

        dosingAndUsing.setAdult(adult);
        dosingAndUsing.setPediatric(pediatrics);
        return dosingAndUsing;
    }

    public static Usage createUsage() {
        Usage usage = new Usage();
        List<Dose> doses = createDoses();
        Forms forms = createForms();

        usage.addDoses(doses);
        usage.setForms(forms);

        return usage;
    }

    public static DosingAndUsingDto createDosingAndUsingDto() {
        DosingAndUsingDto dosingAndUsingDto = new DosingAndUsingDto();
        UsageDto adultDto = createUsageDto();
        UsageDto pediatricsDto = createUsageDto();

        dosingAndUsingDto.setAdult(adultDto);
        dosingAndUsingDto.setPediatric(pediatricsDto);

        return dosingAndUsingDto;
    }

    public static UsageDto createUsageDto() {
        Usage usage = createUsage();
        UsageDto usageDto = new UsageDto();

        usageDto.setId(usage.getId());
        usageDto.setDoses(createDosesDto());
        usageDto.setForms(createFormsDto());

        return usageDto;
    }

    public static List<DoseDto> createDosesDto() {
        List<Dose> doses = createDoses();
        List<DoseDto> doseDtos = new ArrayList<>();

        for (Dose dose : doses) {
            DoseDto doseDto = new DoseDto();

            doseDto.setDiseaseName(dose.getDiseaseName());
            doseDto.setDoseDescription(dose.getDoseDescription());
            doseDto.setId(dose.getId());

            doseDtos.add(doseDto);
        }
        return doseDtos;
    }

    public static FormsDto createFormsDto() {
        Forms forms = createForms();
        FormsDto formsDto = new FormsDto();

        formsDto.setId(forms.getId());
        formsDto.setInjectable(forms.getInjectable());
        formsDto.setOralSolution(forms.getOralSolution());
        formsDto.setPowderForInjections(forms.getPowderForInjections());
        formsDto.setTablet(forms.getTablet());
        formsDto.setTabletDelayed(forms.getTabletDelayed());

        return formsDto;
    }

    public static PregnancyDto createPregnancyDto() {
        Pregnancy pregnancy = createPregnancy();
        PregnancyDto pregnancyDto = new PregnancyDto();
        pregnancyDto.setId(pregnancy.getId());
        pregnancyDto.setCategory(pregnancy.getCategory());
        pregnancyDto.setLactation(pregnancy.getLactation());

        return pregnancyDto;
    }

    public static List<AdverseEffectsDto> createAdverseEffectsDto() {
        List<AdverseEffects> adverseEffects = createAdverseEffects();
        List<AdverseEffectsDto> adverseEffectsDtos = new ArrayList<>();

        for (AdverseEffects adverseEffect : adverseEffects) {
            AdverseEffectsDto adverseEffectsDto = new AdverseEffectsDto();
            adverseEffectsDto.setId(adverseEffect.getId());
            adverseEffectsDto.setDescription(adverseEffect.getDescription());
            adverseEffectsDto.setFrequency(adverseEffect.getFrequency());

            adverseEffectsDtos.add(adverseEffectsDto);
        }

        return adverseEffectsDtos;
    }

    public static PharmacologyDto createPharmacologyDto() {
        PharmacologyDto pharmacologyDto = new PharmacologyDto();
        Pharmacology pharmacology = createPharmacology();
        pharmacologyDto.setId(pharmacology.getId());
        pharmacologyDto.setAbsorption(pharmacology.getAbsorption());
        pharmacologyDto.setDistribution(pharmacology.getDistribution());
        pharmacologyDto.setElimination(pharmacology.getElimination());
        pharmacologyDto.setMechanismOfAction(pharmacology.getMechanismOfAction());
        pharmacologyDto.setMetabolism(pharmacology.getMetabolism());

        return pharmacologyDto;
    }

}
