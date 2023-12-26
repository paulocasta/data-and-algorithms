package com.example.algorithms.advent2023.day1;

import com.example.algorithms.advent2023.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Part2 {

    private static Map<String, Integer> nums = Map.of("one", 1,
            "two", 2,
            "three",3,
            "four",4,
            "five", 5,
            "six", 6,
            "seven",7,
            "eight", 8,
            "nine",9);

    public static void main(String[] args) throws IOException {

        List<String> lines = Util.readFile("day1", "Part1.txt");
        int sum = 0;
        for (String line : lines) {
            //abcone2threexyz
            List<String> values = new ArrayList<>();
            System.out.println();
            System.out.println(line);
            String tmp = "";
            int pointer = 0;
            int pointer2 = 1;
            while (pointer <= line.length()-1) {
                if (Character.isDigit(line.charAt(pointer))) {
                    if (!tmp.isEmpty()) {
                        int p1 = 0;
                        while (p1 <= tmp.length()-1){
                            if (nums.containsKey(tmp)) {
                                values.add(String.valueOf(nums.get(tmp)));
                                tmp = "";
                            } else {
                                tmp = tmp.substring(1, tmp.length());
                            }
                            p1++;
                        }
                    }
                    values.add(String.valueOf(line.charAt(pointer)));
                    tmp = "";
                    pointer++;
                    pointer2=pointer;
                    continue;
                } else {
                    tmp += line.charAt(pointer);
                }

                if (nums.containsKey(tmp)) {
                    values.add(String.valueOf(nums.get(tmp)));
                    pointer2++;
                    pointer = pointer2;
                    tmp = "";
                    continue;
                }
                if (tmp.length() == 5) {
                    tmp = "";
                    pointer = pointer2;
                    pointer2++;
                } else {
                    pointer++;
                }
            }
            if (!tmp.isEmpty()) {
                int p1 = 0;
                while (p1 <= tmp.length()-1){
                    if (nums.containsKey(tmp)) {
                        values.add(String.valueOf(nums.get(tmp)));
                        tmp = "";
                    } else {
                        tmp = tmp.substring(1, tmp.length());
                    }
                    p1++;
                }
            }
            values.forEach(System.out::print);
            sum += Integer.valueOf(values.get(0) + values.get(values.size()-1));
            System.out.println();
            System.out.println(Integer.valueOf(values.get(0) + values.get(values.size()-1)));

        }
        System.out.println(sum);
    }

}
