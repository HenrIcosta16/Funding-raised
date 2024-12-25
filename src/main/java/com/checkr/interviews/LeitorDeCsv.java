package com.checkr.interviews;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class LeitorDeCsv {
    private static final String ARQUIVO_CSV = "startup_funding.csv";

    public static List<String[]> carregarDadosCsv() throws IOException {
        List<String[]> dadosCsv = new ArrayList<>();
        try (CSVReader leitor = new CSVReader(new FileReader(ARQUIVO_CSV))) {
            String[] linha;
            while ((linha = leitor.readNext()) != null) {
                dadosCsv.add(linha);
            }
        }
        if (!dadosCsv.isEmpty()) {
            dadosCsv.remove(0);
        }
        return dadosCsv;
    }
}