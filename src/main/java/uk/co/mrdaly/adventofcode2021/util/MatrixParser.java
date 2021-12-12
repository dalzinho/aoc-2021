package uk.co.mrdaly.adventofcode2021.util;

import java.util.ArrayList;
import java.util.List;

public class MatrixParser {

    public static List<List<Integer>> listOfStringsToIntMatrix(List<String> strings) {
        List<List<Integer>> matrix = new ArrayList<>();

        for (String s : strings) {
            List<Integer> row = new ArrayList<>();
            for (String c : s.split("")) {
                row.add(Integer.parseInt(c));
            }
            matrix.add(row);
        }
        return matrix;
    }
}
