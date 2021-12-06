package uk.co.mrdaly.adventofcode2021._03BinaryDiagnostic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryDiagnostic {
    public int partOne(List<String> strings) {
        final List<String> rotated = transformInput(strings);
        final String gammaBits = calculateGamma(rotated);
        int gammaValue = Integer.parseInt(gammaBits, 2);

        int mask = ((1 << gammaBits.length()) - 1);
        return gammaValue * (gammaValue ^ mask);
    }

    private List<String> transformInput(List<String> strings) {
        if (strings.isEmpty()) return strings;

        List<String> rotated = new ArrayList<>();
        for (int column = 0; column < strings.get(0).length(); column++) {
            StringBuilder sb = new StringBuilder();
            for (int row = strings.size() - 1; row >= 0; row--) {
                sb.append(strings.get(row).charAt(column));
            }
            rotated.add(sb.toString());
        }
        return rotated;
    }

    public String calculateGamma(List<String> strings) {
        StringBuilder sb = new StringBuilder();


        for (String s : strings) {
            final String ones = Arrays.stream(s.split(""))
                    .filter(b -> b.equals("1"))
                    .collect(Collectors.joining());
            boolean isOne = (s.length() - ones.length()) < ones.length();
            sb.append(isOne ? "1" : "0");
        }
        return sb.toString();
    }

    public int partTwo(List<String> strings) {
        int oxygenRating = deriveRating(0, strings, true);
        int co2ScrubberRating = deriveRating(0, strings, false);

        return oxygenRating * co2ScrubberRating;
    }

    public String getMostCommon(List<String> strings, boolean lookingForOne) {
        StringBuilder sb = new StringBuilder();

        for (String s : strings) {
            final String ones = Arrays.stream(s.split(""))
                    .filter(b -> b.equals("1"))
                    .collect(Collectors.joining());

            boolean thingy;
            if (lookingForOne) {
                thingy = (s.length() - ones.length()) <= ones.length();
            } else {
                thingy = (s.length() - ones.length()) > ones.length();
            }
            sb.append(thingy ? "1" : "0");
        }
        return sb.toString();
    }

    private int deriveRating(int index, List<String> strings, boolean isOxygen) {
        if (strings.size() == 1) {
            return Integer.parseInt(strings.get(0), 2);
        }

        final List<String> rotated = transformInput(strings);
        final String gammaBits = getMostCommon(rotated, isOxygen);
        char bit = gammaBits.charAt(index);

        List<String> nextStrings = strings.stream()
                .filter(s -> s.charAt(index) == bit)
                .collect(Collectors.toList());

        return deriveRating(index + 1, nextStrings, isOxygen);
    }
}
