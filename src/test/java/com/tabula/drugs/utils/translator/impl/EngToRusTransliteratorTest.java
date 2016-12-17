package com.tabula.drugs.utils.translator.impl;

import com.tabula.drugs.TabulaDrugRestApplication;
import com.tabula.drugs.utils.translator.api.Transliterator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author Vladyslav_Vinnyk on 12/16/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TabulaDrugRestApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class EngToRusTransliteratorTest {

    @Autowired
    private Transliterator transliterator;

    @Test
    public void shouldTransliterateLipitor() {
        String expected = "липитор";
        String actual = transliterator.transliterate("lipitor");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteMorphine() {
        String expected = "морфин";
        String actual = transliterator.transliterate("morphine");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteNexium() {
        String expected = "нексиум";
        String actual = transliterator.transliterate("nexium");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteAmoxicillin() {
        String expected = "амоксициллин";
        String actual = transliterator.transliterate("amoxicillin");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteLisinopril() {
        String expected = "лизиноприл";
        String actual = transliterator.transliterate("lisinopril");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteEsomeprazole() {
        String expected = "эзомепразол";
        String actual = transliterator.transliterate("esomeprazole");

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void shouldTransliteradteAtorvastatin() {
        String expected = "аторвастатин";
        String actual = transliterator.transliterate("atorvastatin");

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void shouldTransliteradteSimvastatin() {
        String expected = "симвастатин";
        String actual = transliterator.transliterate("simvastatin");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteClopidogrel() {
        String expected = "клопидогрель";
        String actual = transliterator.transliterate("clopidogrel");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteMontelukast() {
        String expected = "монтелукаст";
        String actual = transliterator.transliterate("montelukast");

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void shouldTransliteradteRosuvastatin() {
        String expected = "розувастатин";
        String actual = transliterator.transliterate("rosuvastatin");

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void shouldTransliteradteEscitalopram() {
        String expected = "эсциталопрам";
        String actual = transliterator.transliterate("escitalopram");

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void shouldTransliteradteAzithromycin() {
        String expected = "азитромицин";
        String actual = transliterator.transliterate("azithromycin");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteAlbuterol() {
        String expected = "альбутерол";
        String actual = transliterator.transliterate("albuterol");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteHydrochlorothiazide() {
        String expected = "гидрохлоротиазид";
        String actual = transliterator.transliterate("hydrochlorothiazide");

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void shouldTransliteradteIbuprofen() {
        String expected = "ибупрофен";
        String actual = transliterator.transliterate("ibuprofen");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteZolpidem() {
        String expected = "золпидем";
        String actual = transliterator.transliterate("zolpidem");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteValsartan() {
        String expected = "валсартан";
        String actual = transliterator.transliterate("valsartan");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteDuloxetine() {
        String expected = "дулоксетин";
        String actual = transliterator.transliterate("duloxetine");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteQuetiapine() {
        String expected = "кветиапин";
        String actual = transliterator.transliterate("quetiapine");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradtePromethazine() {
        String expected = "прометазин";
        String actual = transliterator.transliterate("promethazine");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteToRusFluticasone() {
        String expected = "флутиказон";
        String actual = transliterator.transliterate("fluticasone");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteCephalexin() {
        String expected = "цефалексин";
        String actual = transliterator.transliterate("cephalexin");

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void shouldTransliteradtePotassium() {
        String expected = "потассиум";
        String actual = transliterator.transliterate("potassium");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteCyclobenzaprine() {
        String expected = "циклобензаприн";
        String actual = transliterator.transliterate("cyclobenzaprine");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteMethylprednisolone() {
        String expected = "метилпреднизолон";
        String actual = transliterator.transliterate("methylprednisolone");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteMethylphenidate() {
        String expected = "метилфенидат";
        String actual = transliterator.transliterate("methylphenidate");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteFexofenadine() {
        String expected = "фексофенадин";
        String actual = transliterator.transliterate("fexofenadine");

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void shouldTransliteradteCarisoprodol() {
        String expected = "каризопродол";
        String actual = transliterator.transliterate("carisoprodol");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteradteLevetiracetam() {
        String expected = "леветирацетам";
        String actual = transliterator.transliterate("levetiracetam");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliteratePlasma() {
        String expected = "плазма";
        String actual = transliterator.transliterate("plasma");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransliterateAqua() {
        String expected = "аква";
        String actual = transliterator.transliterate("aqua");

        Assert.assertEquals(expected, actual);
    }

    //RUS

    @Test
    @Ignore
    public void shouldTransliterateLipitorRus() {
        String expected = "lipitor";
        String actual = transliterator.transliterate("липитор");

        Assert.assertEquals(expected, actual);
    }
}