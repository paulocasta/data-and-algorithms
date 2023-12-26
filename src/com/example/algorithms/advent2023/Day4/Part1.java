package com.example.algorithms.advent2023.Day4;

import com.example.algorithms.advent2023.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Part1 {

    public static void main(String[] args) throws IOException {
        // Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
        List<String> lines = Util.readFile("day4", "Example.txt");

        int sum = 0;
        for (String line : lines) {
            List<Integer> cardNumbers = new ArrayList<>();
            List<Integer> winningNumbers = new ArrayList<>();
            // 41 48 83 86 17 | 83 86  6 31 17  9 48 53
            String[] splitedCards = line.substring(line.indexOf(":") + 1).split("\\|");
            fillArray(cardNumbers, splitedCards[0].split(" "));
            fillArray(winningNumbers, splitedCards[1].split(" "));
            sum += Math.pow(2,countRepeteadValues(cardNumbers, winningNumbers)-1);
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
