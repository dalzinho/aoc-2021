package uk.co.mrdaly.adventofcode2021._04giantsquid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BingoCard {

    private final List<List<BingoNode>> nodes;

    public BingoCard() {
        nodes = new ArrayList<>();
    }

    public void addRow(String row) {
        if (row.isEmpty()) return;
        final List<BingoNode> nodeList = Arrays.stream(row.trim().split("\\s+"))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .map(BingoNode::new)
                .collect(Collectors.toList());
        nodes.add(nodeList);
    }

    public boolean addCalledNumber(int calledNumber) {
        final Optional<BingoNode> called = nodes.stream()
                .flatMap(List::stream)
                .filter(node -> node.getValue() == calledNumber)
                .findFirst();

        called.ifPresent(BingoNode::setCalled);
        return checkForWinCondition();
    }

    private boolean checkForWinCondition() {
        return hasCompleteRow() || hasCompleteColumn();
    }

    private boolean hasCompleteRow() {
        boolean isComplete = false;
        for (List<BingoNode> node : nodes) {
            isComplete = checkForCompleteness(node);
            if (isComplete) break;
        }
        return isComplete;
    }

    private boolean hasCompleteColumn() {
        boolean isComplete = false;
        for (int column = 0; column < nodes.get(0).size(); column++) {
            List<BingoNode> columnList = new ArrayList<>();
            for (List<BingoNode> node : nodes) {
                columnList.add(node.get(column));
            }
            if (checkForCompleteness(columnList)) {
                isComplete = true;
                break;
            }
        }
        return isComplete;
    }

    private boolean checkForCompleteness(List<BingoNode> bingoNodes) {
        return bingoNodes.stream()
                .allMatch(BingoNode::isCalled);
    }

    public int getSumOfUnmarked() {
        return nodes.stream()
                .flatMap(List::stream)
                .filter(node -> !node.isCalled())
                .mapToInt(BingoNode::getValue)
                .sum();
    }

    public boolean isEmpty() {
        return nodes.isEmpty();
    }



}
