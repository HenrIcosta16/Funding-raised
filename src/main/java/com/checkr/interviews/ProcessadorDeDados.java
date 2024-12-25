package com.checkr.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ProcessadorDeDados {
    private static final String[] CABECALHOS = {"permalink", "company_name", "number_employees", "category", "city", "state", "funded_date", "raised_amount", "raised_currency", "round"};

    public static List<String[]> filtrarDados(List<String[]> dadosCsv, Map<String, String> criterios) {
        if (criterios.isEmpty()) {
            return dadosCsv;
        }

        List<String[]> dadosFiltrados = new ArrayList<>();
        for (String[] linha : dadosCsv) {
            boolean corresponde = criterios.entrySet().stream()
                .allMatch(criterio -> {
                    int indiceColuna = Arrays.asList(CABECALHOS).indexOf(criterio.getKey());
                    return indiceColuna >= 0 && linha[indiceColuna].equals(criterio.getValue());
                });
            if (corresponde) {
                dadosFiltrados.add(linha);
            }
        }
        return dadosFiltrados;
    }
}