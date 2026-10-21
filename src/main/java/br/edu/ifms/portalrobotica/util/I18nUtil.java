package br.edu.ifms.portalrobotica.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nUtil {

    public String getMensagem(Locale locale, String chave) {
        ResourceBundle bundle = ResourceBundle.getBundle(
                "resources.message", locale);

        return bundle.getString(chave);
        
    }
}