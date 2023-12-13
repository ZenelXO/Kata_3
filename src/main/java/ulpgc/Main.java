package ulpgc;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Kata2
        List<Person> people = new TsvFileLoader(new File("persons.tsv")).load();
        Map<String, Integer> hist = new WeightHistogram(20, people).calculate();

        //Creamos un mapa para guardar los pesos de las personas
        Map<String, Integer> histogramData = new HashMap<>();

        for(String key : hist.keySet().stream().sorted().toList()){
            System.out.println(key + " -> " + hist.get(key));
            histogramData.put(key, hist.get(key));
        }

        //Kata3
        MainFrame display = new MainFrame(histogramData);
        display.setVisible(true);
    }
}