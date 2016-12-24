package com.tabula.drugs.utils.translator.impl;

import com.tabula.drugs.TabulaDrugRestApplication;
import com.tabula.drugs.dto.InteractionDto;
import com.tabula.drugs.service.api.InteractionCheckerService;
import com.tabula.drugs.utils.translator.api.Transliterator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Vladyslav_Vinnyk on 12/20/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TabulaDrugRestApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class RusToEngTransliteratorTest {
    @Autowired
    private Transliterator transliterator;

    @Test
    public void shouldTransliterateLipitorRus() {
        String expected = "lipitor";
        String actual = transliterator.transliterate("липитор");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteMorphineRusToEng() {
        String expected = "morphine";
        String actual = transliterator.transliterate("морфин");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteNexiumRusToEng() {
        String expected = "nexium";
        String actual = transliterator.transliterate("нексиум");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteAmoxicillinRusToEng() {
        String expected = "amoxicillin";
        String actual = transliterator.transliterate("амоксициллин");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteLisinoprilRusToEng() {
        String expected = "lisinopril";
        String actual = transliterator.transliterate("лизиноприл");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteEsomeprazoleRusToEng() {
        String expected = "esomeprazole";
        String actual = transliterator.transliterate("эзомепразол");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteAtorvastatinRusToEng() {
        String expected = "atorvastatin";
        String actual = transliterator.transliterate("аторвастатин");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteSimvastatinRusToEng() {
        String expected = "simvastatin";
        String actual = transliterator.transliterate("симвастатин");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteClopidogrelRusToEng() {
        String expected = "clopidogrel";
        String actual = transliterator.transliterate("клопидогрель");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteMontelukastRusToEng() {
        String expected = "montelukast";
        String actual = transliterator.transliterate("монтелукаст");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteRosuvastatin() {
        String expected = "rosuvastatin";
        String actual = transliterator.transliterate("розувастатин");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteEscitalopramRusToEng() {
        String expected = "escitalopram";
        String actual = transliterator.transliterate("эсциталопрам");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteAzithromycinRusToEng() {
        String expected = "azithromycin";
        String actual = transliterator.transliterate("азитромицин");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteAlbuterolRusToEng() {
        String expected = "albuterol";
        String actual = transliterator.transliterate("альбутерол");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteHydrochlorothiazideRusToEng() {
        String expected = "hydrochlorothiazide";
        String actual = transliterator.transliterate("гидрохлоротиазид");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteIbuprofenRusToEng() {
        String expected = "ibuprofen";
        String actual = transliterator.transliterate("ибупрофен");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteZolpidemRusToEng() {
        String expected = "zolpidem";
        String actual = transliterator.transliterate("золпидем");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteValsartanRusToEng() {
        String expected = "valsartan";
        String actual = transliterator.transliterate("валсартан");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteDuloxetineRusToEng() {
        String expected = "duloxetine";
        String actual = transliterator.transliterate("дулоксетин");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteQuetiapineRusToEng() {
        String expected = "quetiapine";
        String actual = transliterator.transliterate("кветиапин");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradtePromethazineRusToEng() {
        String expected = "promethazine";
        String actual = transliterator.transliterate("прометазин");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteToRusFluticasoneRusToEng() {
        String expected = "fluticasone";
        String actual = transliterator.transliterate("флутиказон");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteCephalexinRusToEng() {
        String expected = "cephalexin";
        String actual = transliterator.transliterate("цефалексин");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradtePotassiumRusToEng() {
        String expected = "potassium";
        String actual = transliterator.transliterate("потассиум");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteCyclobenzaprineRusToEng() {
        String expected = "cyclobenzaprine";
        String actual = transliterator.transliterate("циклобензаприн");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteMethylprednisoloneRusToEng() {
        String expected = "methylprednisolone";
        String actual = transliterator.transliterate("метилпреднизолон");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteMethylphenidateRusToEng() {
        String expected = "methylphenidate";
        String actual = transliterator.transliterate("метилфенидат");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteFexofenadineRusToEng() {
        String expected = "fexofenadine";
        String actual = transliterator.transliterate("фексофенадин");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteCarisoprodolRusToEng() {
        String expected = "carisoprodol";
        String actual = transliterator.transliterate("каризопродол");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteLevetiracetamRusToEng() {
        String expected = "levetiracetam";
        String actual = transliterator.transliterate("леветирацетам");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteratePlasmaRusToEng() {
        String expected = "plasma";
        String actual = transliterator.transliterate("плазма");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliterateAquaEngToRus() {
        String expected = "aqua";
        String actual = transliterator.transliterate("аква");

        Assert.assertEquals(expected, actual);
    }

    @Autowired
    private InteractionCheckerService interactionCheckerService;

    @Test
    public void tryIt() {
        Set<String> set = new HashSet<>();
        set.add("313820");
        set.add("1100072");
        List<InteractionDto> interactions = interactionCheckerService.getInteractions(set);

        System.out.println("!! " + interactions);
    }

}