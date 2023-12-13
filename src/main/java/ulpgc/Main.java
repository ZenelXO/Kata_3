package ulpgc;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Kata2
        List<Person> people = new TsvFileLoader(new File("persons.tsv")).load();
        Map<String, Integer> hist = new WeightHistogram(20, people).calculate();
        for(String key : hist.keySet().stream().sorted().toList()){
            System.out.println(key + " -> " + hist.get(key));
        }

        //Kata3
        MainFrame display = new MainFrame();
        display.setVisible(true);
    }
}