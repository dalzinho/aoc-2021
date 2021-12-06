package uk.co.mrdaly.adventofcode2021._04giantsquid;

public class BingoNode {

    private final int value;
    private boolean called;

    public BingoNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isCalled() {
        return called;
    }

    public void setCalled() {
        this.called = true;
    }

    @Override
    public String toString() {
        return "BingoNode{" +
                "value=" + value +
                ", called=" + called +
                '}';
    }
}
