package com.example.algorithms.advent2023.Day4;

import com.example.algorithms.advent2023.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Part2 {

    public static void main(String[] args) throws IOException {

        List<String> lines = Util.readFile("day4", "Test.txt");
        int sum = 0, gameNumber = 1;
        Map<Integer, Card> games = new HashMap<>();
        for (String line : lines) {
            List<Integer> cardNumbers = new ArrayList<>();
            List<Integer> winningNumbers = new ArrayList<>();
            String[] splitedCards = line.substring(line.indexOf(":") + 1).split("\\|");
            fillArray(cardNumbers, splitedCards[0].split(" "));
            fillArray(winningNumbers, splitedCards[1].split(" "));

            int winners = countRepeteadValues(cardNumbers, winningNumbers);

            if (games.get(gameNumber) == null) {
                games.put(gameNumber, new Card( 1,0));
            }
            int tmpGame = gameNumber + 1;
            int tmpWinners = winners;

            // add to next cards copies
            while (tmpWinners > 0) {
                if (games.get(tmpGame) == null) {
                    games.put(tmpGame, new Card( 1,0));
                }
                games.get(tmpGame).copies += 1;

                tmpGame++;
                tmpWinners--;
            }

            Card currCard = games.get(gameNumber);
            tmpGame = gameNumber + 1;

            while (winners > 0) {
                if (games.get(tmpGame) == null) {
                    games.put(tmpGame, new Card( 1,0));
                }
                games.get(tmpGame).copies += currCard.copies;

                tmpGame++;
                winners--;
            }
            gameNumber++;
        }
        for(Map.Entry<Integer, Card> game : games.entrySet()) {
            sum += game.getValue().copies + game.getValue().orig;
        }
        System.out.println(sum);
    }

    private static int countRepeteadValues(List<Integer> cardNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int num : cardNumbers) {
            if (winningNumbers.contains(num)) {
                count++;
            }
        }
        return count;
    }

    private static void fillArray(List<Integer> arrayToFill, String[] fillArray) {
        for (String value : fillArray) {
            if (!value.trim().isEmpty()) {
                arrayToFill.add(Integer.parseInt(value.trim()));
            }
        }
    }
}

class Card {
    int orig;
    int copies;
    public Card(int orig, int copies) {
        this.orig = orig;
        this.copies = copies;
    }
}