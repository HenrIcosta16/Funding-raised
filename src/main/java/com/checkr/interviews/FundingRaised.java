package com.checkr.interviews;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FundingRaised {

    public static List<Map<String, String>> where(Map<String, String> options) throws IOException {
        List<String[]> csvData = LeitorDeCsv.carregarDadosCsv();
        csvData = ProcessadorDeDados.filtrarDados(csvData, options);
        return ConversorDeDados.converterLista(csvData);
    }

    public static Map<String, String> findBy(Map<String, String> options) throws IOException, NoSuchEntryException {
        List<String[]> csvData = LeitorDeCsv.carregarDadosCsv();
        List<String[]> filteredData = ProcessadorDeDados.filtrarDados(csvData, options);

        if (filteredData.isEmpty()) {
            throw new NoSuchEntryException();
        }

        return ConversorDeDados.converterLinhaUnica(filteredData.get(0));
    }
   public static void main(String[] args) {
        try {
            Map<String, String> options = new HashMap<>();
            options.put("company_name", "Facebook");
            options.put("round", "a");
    
            System.out.print(FundingRaised.where(options).size());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Error e) {
            System.out.println("No entry found.");
        }
    }
}
class NoSuchEntryException extends Exception {}