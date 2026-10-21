package br.edu.ifms.portalrobotica.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ManipulacaoData {

    public static Date converterData(String data) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.parse(data);
    }
}
