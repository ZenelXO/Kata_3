package ulpgc;

import java.util.*;

public class WeightHistogram implements HistogramCalculator{
    private final int range;
    private final List<Person> people;

    public WeightHistogram(int range, List<Person> people) {
        this.range = range;
        this.people = people;
    }


    @Override
    public Map<String, Integer> calculate() {
        Map<String, Integer> result = new HashMap<>();
        for(Person person : people){
            String key = toRange(person.getWeight());
            result.put(key, result.getOrDefault(key, 0)+1);
        }
        return result;
    }

    private String toRange(double weight) {
        return low_limit(weight) + "-" + high_limit(weight);
    }

    private int high_limit(double weight) {
        return low_limit(weight) + range;
    }

    private int low_limit(double weight) {
        return (int) (weight / range) * range;
    }
}