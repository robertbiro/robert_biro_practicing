package org.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Rucksack {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\user\\Documents\\greenfox\\robert_biro_practicing\\src\\org\\day3\\rucksack.txt";
        readFromFile(fileName);
    }
    public static String readFromFile (String fileName) {
        String line = "";
        int sumAll = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine()) != null) {
                int value = getCharArray(line);
                System.out.println(value + "  18 ");
                sumAll += value;
                line = "";
            }
            reader.close();
        } catch (IOException exception) {
            System.out.println("Error!");
        }
        System.out.println(sumAll);
        return line;
    }

    public static int getCharArray (String line) {      //get line, make 2 two char array
        char[] charLine = line.toCharArray();
        int len = charLine.length;
        char[] firstHalf = new char[len / 2];
        char[] secondHalf = new char[len / 2];
        for (int i = 0; i < len; i++) {
            if (i < len/2) {
                firstHalf[i] = charLine[i];
                //b = Arrays.copyOfRange(a, 0, pos);
            } else {
                secondHalf[i - len/2] = charLine[i];
                // c = Arrays.copyOfRange(a, pos, n);
            }
        }
        int valueOfFounded = getChar(firstHalf, secondHalf);       //get 2 two char array, make one char
        return valueOfFounded;
    }

    public static int getChar(char[] firstHalf, char[] secondHalf) {    //get 2 two char array, make one char -- OK
        char founded = 0;
        for (int j = 0; j < firstHalf.length; j++) {
                for (int k = 0; k < secondHalf.length; k++) {
                    if (firstHalf[j] == secondHalf[k]) {
                        founded = secondHalf[k];
                        break;
                    }
                }
            }
        int valueOfFounded = getCharValue(founded);     //get value of char
        System.out.println(founded);
        return valueOfFounded;
    }

    public static int getCharValue (char foundedChar) {     //get value of char
        int value = foundedChar;
        //Lowercase item types a through z have priorities 1 through 26.
        //Uppercase item types A through Z have priorities 27 through 52.
        int upper = 38;
        int lower = 96;
        if (Character.isUpperCase(foundedChar)) {
            value = value - upper;
        } else {
            value = value - lower;
        }
        return value;
    }
}

