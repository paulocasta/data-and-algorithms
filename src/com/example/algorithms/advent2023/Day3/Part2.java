package com.example.algorithms.advent2023.Day3;

import com.example.algorithms.advent2023.Util;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Part2 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Util.readFile("day3", "Example.txt");
        int neoLength = 140;
        Character[][] neo = new Character[neoLength][neoLength];
        int l = 0;
        for (String line : lines) {
            for(int id = 0; id < line.length(); id++) {
                neo[l][id] = line.charAt(id);
            }
            l++;
        }
        int sum = 0;
        for(int i=0; i<neoLength; i++) {
            for(int j=0; j<neoLength; j++) {
                Character what = neo[i][j];
                if (!Character.isDigit(what) && what == '*') {
                    int up = findNumber(neo,i-1,j);
                    int upLeft = findNumber(neo,i-1,j-1);
                    int upRight = findNumber(neo,i-1,j+1);
                    int left =  findNumber(neo,i,j-1);
                    int right =  findNumber(neo,i,j+1);
                    int down =  findNumber(neo,i+1,j);
                    int downLeft =  findNumber(neo,i+1,j-1);
                    int downRight =  findNumber(neo,i+1,j+1);
                    List<Integer> tmpList = List.of(up, upLeft, upRight, left, right, down, downLeft, downRight);
                    List<Integer> rest = tmpList.stream().filter( num -> num > 0).toList();
                    if (rest.size() >= 2) {
                        sum += rest.stream().reduce(1, (a, b) -> a * b);
                    }
                }
            }
        }
        System.out.println(sum);
    }

    private static int findNumber(Character[][] neo, int row, int column) {
        if (row < 0 || column < 0) {
            return 0;
        }
        Character c = neo[row][column];
        if (c == '.') {
            return 0;
        }
        String num = "";
        if (Character.isDigit(c)) {
            int leftCol = column;
            int rightCol = column+1;
            StringBuilder leftStr = new StringBuilder();
            StringBuilder rightStr = new StringBuilder();
            // ver izq
            while (leftCol >= 0) {
                Character lc = neo[row][leftCol];
                if(Character.isDigit(lc)) {
                    leftStr.append(lc);
                    neo[row][leftCol] = '.';
                } else {
                    break;
                }
                leftCol--;
            }
            // ver der
            while (rightCol <= 139) {
                Character lc = neo[row][rightCol];
                if(Character.isDigit(lc)) {
                    rightStr.append(lc);
                    neo[row][rightCol] = '.';
                } else {
                    break;
                }
                rightCol++;
            }
            num+=leftStr.reverse().toString() + rightStr;
        }
        return Integer.parseInt(num);
    }
}
