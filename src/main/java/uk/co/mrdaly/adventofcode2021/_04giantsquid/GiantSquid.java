package uk.co.mrdaly.adventofcode2021._04giantsquid;

import java.util.*;
import java.util.stream.Collectors;

public class GiantSquid {

    public int partOne(String calledNumbers, List<String> rawBoards) {
        final List<BingoCard> bingoCards = buildCards(rawBoards);

        for (String number : calledNumbers.split(",")) {
            int i = Integer.parseInt(number);

            for (BingoCard card : bingoCards) {
                final boolean wins = card.addCalledNumber(i);
                if (wins) {
                    return card.getSumOfUnmarked() * i;
                }
            }
        }
        return -1;
    }

    private List<BingoCard> buildCards(List<String> rawBoards) {
        List<BingoCard> cards = new ArrayList<>();

        BingoCard card = new BingoCard();
        for (String line : rawBoards) {
            if (line.isEmpty() && !card.isEmpty()) {
                cards.add(card);
                card = new BingoCard();
            } else if (!line.isEmpty()) {
                card.addRow(line);
            }
        }
        if (!card.isEmpty()) {
            cards.add(card);
        }
        return cards;
    }

    public int partTwo(String calledNumbers, List<String> sampleCards) {
        final List<BingoCard> bingoCards = buildCards(sampleCards);

        final List<Integer> collect = Arrays.stream(calledNumbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        return getLastRemaining(new ArrayDeque<>(collect), bingoCards);
    }

    public int getLastRemaining(Deque<Integer> calledNumbers, List<BingoCard> cards) {
        int number = calledNumbers.pop();

        List<BingoCard> notYetWon = cards.stream()
                .filter(card -> !card.addCalledNumber(number))
                .collect(Collectors.toList());

        if (notYetWon.size() == 1) {
            BingoCard lastCard = notYetWon.get(0);
            while (!calledNumbers.isEmpty()) {
                int next = calledNumbers.pop();
                boolean win = lastCard.addCalledNumber(next);
                if (win) {
                    return lastCard.getSumOfUnmarked() * next;
                }

            }
        }
        return getLastRemaining(calledNumbers, notYetWon);
    }
}
