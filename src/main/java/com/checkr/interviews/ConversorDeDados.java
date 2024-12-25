
package com.checkr.interviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConversorDeDados {
    private static final String[] CABECALHOS = {"permalink", "company_name", "number_employees", "category", "city", "state", "funded_date", "raised_amount", "raised_currency", "round"};

    public static List<Map<String, String>> converterLista(List<String[]> dadosCsv) {
        List<Map<String, String>> resultado = new ArrayList<>();
        for (String[] linha : dadosCsv) {
            resultado.add(converterLinhaUnica(linha));
        }
        return resultado;
    }

    public static Map<String, String> converterLinhaUnica(String[] linha) {
        Map<String, String> mapa = new HashMap<>();
        for (int i = 0; i < CABECALHOS.length; i++) {
            mapa.put(CABECALHOS[i], linha[i]);
        }
        return mapa;
    }
}