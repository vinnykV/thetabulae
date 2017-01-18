package com.tabula.drugs;

/**
 * @author Vladyslav_Vinnyk on 1/18/2017.
 */
public class TestConstants {
    public static final String MEDICINE_REQUEST = "{  \n" +
            "   \"adverseEffects\":[  \n" +
            "      {  \n" +
            "         \"frequency\":\"MORE_TEN\",\n" +
            "         \"description\":\"Angioedema\\nBronchospasm\\nCNS alteration\\nDermatologic problems\\nGI pain, ulceration, bleeding\\nHepatotoxicity\\nHearing loss\\nNausea\\nPlatelet aggregation inhibition\\nPremature hemolysis\\nPulmonary edema (salicylate-induced, noncardiogenic)\\nRash\\nRenal damage\\nTinnitus\\nUrticaria\\nVomiting\"\n" +
            "      }\n" +
            "   ],\n" +
            "   \"dosingAndUsing\":{  \n" +
            "      \"adult\":{  \n" +
            "         \"doses\":[  \n" +
            "            {  \n" +
            "               \"diseaseName\":\"Acute Coronary Syndrome\",\n" +
            "               \"doseDescription\":\"For use as adjunctive antithrombotic effects for ACS (ST-segment elevation myocardial infarction [STEMI], unstable angina [UA]/non-ST-segment elevation myocardial infarction [NSTEMI])\\nAcute symptoms\\n160-325 mg PO; chew nonenteric-coated tablet upon presentation (within minutes of symptoms)\\nIf unable to take PO, may give 300-600 mg suppository PR\\nMaintenance (secondary prevention)\\n75-81 mg PO qDay indefinitely (preferred dose); may give 81-325 mg/day\\nRegimen may depend on coadministered drugs or comorbid conditions\\nCoadministered with ticagrelor: 81 mg PO qDay\\nPercutaneous transluminal coronary angioplasty\\nAdjunctive aspirin therapy to support reperfusion with primary PCI (with or without fibrinolytic therapy)\\nPreoperative dose: 162-325 mg PO before procedure\\nMaintenance: 81 mg PO qDay indefinitely (preferred dose) may give 81-325 mg/day\\nRegimen may depend on coadministered drugs or comorbid conditions\\nCoadministered with ticagrelor: 81 mg PO qDay\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"diseaseName\":\"Ischemic Stroke & Transient Ischemic Attack\",\n" +
            "               \"doseDescription\":\"50-325 mg/day PO within 48 hours of stroke or TIA, then 75-100 mg/day PO\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"diseaseName\":\"Rheumatoid Arthritis\",\n" +
            "               \"doseDescription\":\"3 g/day PO in divided doses; increased PRN for anti-inflammatory efficacy (target plasma salicylate, 150-300 mcg/mL)\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"diseaseName\":\"Spondyloarthropathy\",\n" +
            "               \"doseDescription\":\"3.6-5.4 g/day PO in divided doses; monitor serum concentrations\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"diseaseName\":\"Colorectal Cancer (Off-label)\",\n" +
            "               \"doseDescription\":\"Prophylaxis\\n600 mg/day PO\\nDecreases risk of developing hereditary colorectal cancer (ie, Lynch syndrome) by 60% if taken daily for at least 2 years\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"diseaseName\":\"Dosing Modifications\",\n" +
            "               \"doseDescription\":\"Renal impairment\\nCrCl >10 mL/min: Dose adjustment not necessary\\nCrCl <10 mL/min: Not recommended\\nHepatic impairment\\nSevere liver disease: Not recommended\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"forms\":{  \n" +
            "            \"tablet\":\"81mg\\n325mg\\n500mg\"\n" +
            "         }\n" +
            "      },\n" +
            "      \"pediatric\":{  \n" +
            "         \"doses\":[  \n" +
            "            {  \n" +
            "               \"diseaseName\":\"Pain & Fever\",\n" +
            "               \"doseDescription\":\"<12 years\\n10-15 mg/kg PO q4hr, up to 60-80 mg/kg/day\\n≥12 years\\n325-650 mg PO/PR q4-6hr PRN\\nControlled/extended/delayed-release products (enteric coated): 650-1300 mg PO q8hr; not to exceed 3.9 g/day\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"diseaseName\":\"Kawasaki Disease\",\n" +
            "               \"doseDescription\":\"Febrile phase: 80-100 mg/kg/day PO divided q6hr for up to 14 days (48-72 hours after fever defervescence) \\nMaintenance: 3-6 mg/kg/day PO in single dose\"\n" +
            "            },\n" +
            "            {  \n" +
            "               \"diseaseName\":\"Dosing Considerations\",\n" +
            "               \"doseDescription\":\"Toxic dose: 200 mg/kg\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"forms\":{  \n" +
            "            \"tablet\":\"81mg\\n325mg\\n500mg\"\n" +
            "         }\n" +
            "      }\n" +
            "   },\n" +
            "   \"name\":\"aspirin\",\n" +
            "   \"pharmacology\":{  \n" +
            "      \"absorption\":\"Bioavailability: 80-100%\\nOnset: PO, 5-30 min; PR, 1-2 hr\\nDuration: PO, 4-6 hr; PR, >7 hr\\nPeak plasma time: PO, 0.25-3 hr\\nPeak plasma concentration: Analgesia/antipyresis, 30-100 mcg/mL; anti-inflammatory, 150-300 mcg/mL\",\n" +
            "      \"distribution\":\"Protein bound: ≤100 mcg/mL, 90-95%; 100-400 mcg/mL, 70-85%; higher concentrations, 25-60%\\nVd: 170 mL/kg\",\n" +
            "      \"elimination\":\"Half-life: Low dose, 2-3 hr; higher dose, 15-30 hr\\nRenal clearance: 80-100% in 24-72 hr\\nExcretion: Urine (80-100%), sweat, saliva, feces\\nDialyzable: Yes\",\n" +
            "      \"mechanismOfAction\":\"Inhibits synthesis of prostaglandin by cyclooxygenase; inhibits platelet aggregation; has antipyretic and analgesic activity\",\n" +
            "      \"metabolism\":\"Metabolized by liver via microsomal enzyme system\\nMetabolites: Salicylurate, salicyl phenolic glucuronide, salicyl acyl glucuronide, 2,5-dihydroxybenzoic acid (gentisic acid), 2,3-dihydroxybenzoic acid, 2,3,5-trihydroxybenzoic acid, gentisuric acid (active)\\nEnzymes inhibited: Cyclooxygenase (insignificant)\"\n" +
            "   },\n" +
            "   \"pregnancy\":{  \n" +
            "      \"category\":\"C\",\n" +
            "      \"lactation\":\"Drug enters breast milk; decision should be made regarding whether to discontinue nursing or to discontinue drug, taking into account importance of drug to mother.\"\n" +
            "   }\n" +
            "}";
}
