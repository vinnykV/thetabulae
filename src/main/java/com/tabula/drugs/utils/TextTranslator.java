package com.tabula.drugs.utils;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

/**
 * @author Vladyslav_Vinnyk on 12/20/2016.
 */
public class TextTranslator {

    public static String translate(String string) {
        Translate.setClientId("theTabulae");
        Translate.setClientSecret("6Im8QR9bd1Et+ADDNplKZiL+7jxRFXKrAN1NG0WdiKI=");

        String translatedText = null;
        try {
            translatedText = Translate.execute(string, Language.ENGLISH, Language.RUSSIAN);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return translatedText;
    }
}