package uk.co.mrdaly.adventofcode2021._08SevenSegmentSearch;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SevenSegmentSearch {

    public int partOne(List<String> input) {
        int count = 0;
        for (String s : input) {
            String[] inputs = s.split(" \\| ");
            String data = inputs[1];
            for (String datum : data.split(" ")) {
                if (Arrays.asList(2, 3, 4, 7).contains(datum.length())) {
                    count++;
                }
            }
        }
        return count;
    }


    public int partTwo(List<String> input) {
        int count = 0;
        for (String s : input) {
            String[] inputs = s.split(" \\| ");
            String signalPatterns = inputs[0];
            String data = inputs[1];
            final Map<String, Integer> stringIntegerMap = buildPatternLookup(signalPatterns);
            String result = "";
            for (String datum : data.split(" ")) {
                result += stringIntegerMap.getOrDefault(sortString(datum), 0);
            }
            count += Integer.parseInt(result);
        }
        return count;
    }

    private Map<String, Integer> buildPatternLookup(String signalPatterns) {
        Map<String, Integer> lookup = new HashMap<>();
        final List<String> patternElements = Arrays.asList(signalPatterns.split(" "));

        String zero = null;
        String one = getStringsOfLength(patternElements, 2).get(0);
        String two = null;
        String three = null;
        String four = getStringsOfLength(patternElements, 4).get(0);
        String five = null;
        String six = null;
        String seven = getStringsOfLength(patternElements, 3).get(0);
        String eight = getStringsOfLength(patternElements, 7).get(0);
        String nine = null;

        for (String s : getStringsOfLength(patternElements, 6)) {
            if (intersectionOf(s, four).size() == 4) {
                nine = s;
            } else if (intersectionOf(s, one).size() == 1) {
                six = s;
            } else {
                zero = s;
            }
        }

        for (String s : getStringsOfLength(patternElements, 5)) {
            if (intersectionOf(s, one).size() == 2) {
                three = s;
            } else if (intersectionOf(s, nine).size() == 5) {
                five = s;
            } else {
                two = s;
            }
        }

        lookup.put(sortString(zero), 0);
        lookup.put(sortString(one), 1);
        lookup.put(sortString(two), 2);
        lookup.put(sortString(three), 3);
        lookup.put(sortString(four), 4);
        lookup.put(sortString(five), 5);
        lookup.put(sortString(six), 6);
        lookup.put(sortString(seven), 7);
        lookup.put(sortString(eight), 8);
        lookup.put(sortString(nine), 9);

        return lookup;
    }

    private List<String> intersectionOf(String s1, String s2) {
        List<String> intersection = new ArrayList<>();

        for (String s : s2.split("")) {
            if (s1.contains(s)) {
                intersection.add(s);
            }
        }
        return intersection;
    }

    private List<String> getStringsOfLength(List<String> list, int length) {
        return list.stream()
                .filter(s -> s.length() == length)
                .collect(Collectors.toList());
    }

    private String sortString(String s) {
        return Stream.of(s.split(""))
                .sorted()
                .collect(Collectors.joining(""));
    }




}
