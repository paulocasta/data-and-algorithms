package com.example.algorithms.advent2023.day2;

import com.example.algorithms.advent2023.Util;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Util.readFile("day2", "Test.txt");
        Pattern pb = Pattern.compile("(\\d+).(blue)");
        Pattern pr = Pattern.compile("(\\d+).(red)");
        Pattern pg = Pattern.compile("(\\d+).(green)");


        int sum = 0;
        for (String line : lines) {
            int possibleRed = 0;
            int possibleGreen = 0;
            int possibleBlue = 0;
            String[] sp = line.split(":");

            String[] sets = sp[1].split(";");
            for (String set : sets) {
                Matcher mr = pr.matcher(set);
                Matcher mb = pb.matcher(set);
                Matcher mg = pg.matcher(set);
                if (mr.find() && Integer.parseInt(mr.group(1)) > possibleRed) {
                    possibleRed = Integer.parseInt(mr.group(1));
                }
                if (mg.find() && Integer.parseInt(mg.group(1)) > possibleGreen) {
                    possibleGreen = Integer.parseInt(mg.group(1));
                }
                if (mb.find() && Integer.parseInt(mb.group(1)) > possibleBlue) {
                    possibleBlue = Integer.parseInt(mb.group(1));
                }
            }
            System.out.println("possibleRed:"+possibleRed + " possibleGreen:"+possibleGreen+ " possibleBlue:"+possibleBlue);
            sum+=possibleRed*possibleGreen*possibleBlue;
        }
        System.out.println(sum);
    }
}
