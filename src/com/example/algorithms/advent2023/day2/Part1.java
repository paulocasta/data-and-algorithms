package com.example.algorithms.advent2023.day2;

import com.example.algorithms.advent2023.Util;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Util.readFile("day2", "Test.txt");
        Pattern pb = Pattern.compile("(\\d+).(blue)");
        Pattern pr = Pattern.compile("(\\d+).(red)");
        Pattern pg = Pattern.compile("(\\d+).(green)");

        int possibleRed = 12;
        int possibleGreen = 13;
        int possibleBlue = 14;
        int sum = 0;
        for (String line : lines) {
            boolean valid = true;
            String[] sp = line.split(":");

            String[] sets = sp[1].split(";");
            for (String set : sets) {
                Matcher mr = pr.matcher(set);
                Matcher mb = pb.matcher(set);
                Matcher mg = pg.matcher(set);
                if (mr.find() && Integer.parseInt(mr.group(1)) > possibleRed) {
                   valid = false;
                   break;
                }
                if (mg.find() && Integer.parseInt(mg.group(1)) > possibleGreen) {
                    valid = false;
                    break;
                }
                if (mb.find() && Integer.parseInt(mb.group(1)) > possibleBlue) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                System.out.println(line);
                String gameValue = sp[0].replace("Game ", "");
                sum += Integer.parseInt(gameValue);
            }
        }
        System.out.println(sum);
    }
}
