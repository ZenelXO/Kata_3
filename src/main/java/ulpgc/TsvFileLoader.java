package ulpgc;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class TsvFileLoader implements PersonLoader{
    private final File file;

    public TsvFileLoader(File file) {
        this.file = file;
    }

    @Override
    public List<Person> load() {
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            return reader.lines().skip(1).map(this::toPerson).collect(Collectors.toList());
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private Person toPerson(String lines) {
        String[] words = lines.split("\t");
        return new Person(
                parseInt(words[0]),
                parseDouble(words[1]),
                parseDouble(words[2]));
    }
}