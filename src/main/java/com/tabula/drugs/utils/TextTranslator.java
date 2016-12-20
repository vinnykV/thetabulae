package com.tabula.drugs.utils;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

/**
 * @author Vladyslav_Vinnyk on 12/20/2016.
 */
public class TextTranslator {

    public static String translate(String string) throws Exception {
        Translate.setClientId("theTabulae");
        Translate.setClientSecret("6Im8QR9bd1Et+ADDNplKZiL+7jxRFXKrAN1NG0WdiKI=");

        String translatedText = Translate.execute(string, Language.ENGLISH, Language.RUSSIAN);

        return translatedText;
    }
}