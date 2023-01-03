package org.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Rucksack2 {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\user\\Documents\\greenfox\\robert_biro_practicing\\src\\org\\day3\\rucksack.txt";
        readFromFile(fileName);
    }

    public static void readFromFile(String fileName) {
        ArrayList<char[]> charCounter = new ArrayList<>();
        int sum = 0;
        int value = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = "";
            while ((line = reader.readLine()) != null) {
                char[] charLine = line.toCharArray();
                charCounter.add(charLine);
                if (charCounter.size() == 3) {
                     value = getChar(charCounter);
                    System.out.println(value + "  29. line ");
                    charCounter.clear();
                    sum += value;
                }
            }
                reader.close();
            System.out.println(sum);
        } catch(IOException exception){
                System.out.println("Error!");
            }
    }

    public static int  getChar(ArrayList<char[]> charCounter) {    //get three char array, make one char -- OK
        int sum = 0;
        char founded = 0;
        char ch1[] = charCounter.get(0);;
        char ch2[] = charCounter.get(1);
        char ch3[] = charCounter.get(2);
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        Arrays.sort(ch3);
        //System.out.println(ch1);
        //System.out.println(ch2);
        //System.out.println(ch3);

        //https://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/
        int i = 0, j = 0, k = 0;

        while (i < ch1.length && j < ch2.length
               && k < ch3.length) {
           // If x = y and y = z, print any of them and
           // move ahead in all arrays
           if (ch1[i] == ch2[j] && ch2[j] == ch3[k]) {
               founded = ch1[i];
               i++;
               j++;
               k++;
           }

           // x < y
           else if (ch1[i] < ch2[j])
               i++;

               // y < z
           else if (ch2[j] < ch3[k])
               j++;

               // We reach here when x > y and z < y, i.e., z
               // is smallest
           else
               k++;
       }
        int value = getCharValue(founded);
        System.out.println(founded + "  "  + value);
        return value;
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

