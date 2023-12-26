package com.example.algorithms.advent2023.day1;

import com.example.algorithms.advent2023.Util;

import java.io.IOException;
import java.util.List;

public class Part1 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Util.readFile("day1", "Part1.txt");
        int sum = 0;
        for (String line : lines) {
            int leftP = 0;
            int rightP = line.length()-1;
            String lS = "";
            String rS = "";
            while (leftP <= rightP) {
                if (Character.isDigit(line.charAt(leftP)) && lS.isEmpty()) {
                    lS = String.valueOf(line.charAt(leftP));
                }
                if (Character.isDigit(line.charAt(rightP)) && rS.isEmpty()) {
                    rS = String.valueOf(line.charAt(rightP));
                }
                if (lS.isEmpty()) {
                    leftP++;
                }
                if (rS.isEmpty()) {
                    rightP--;
                }
                if (!lS.isEmpty() &&!rS.isEmpty()) {
                    break;
                }
            }
            sum += Integer.parseInt(lS+rS);
        }
        System.out.println(sum);
    }
}
