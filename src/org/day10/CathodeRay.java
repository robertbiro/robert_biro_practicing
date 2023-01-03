package org.day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;

public class CathodeRay {

    public static void main(String[] args) {
        String fileName = "C:\\Users\\user\\Documents\\greenfox\\robert_biro_practicing\\src\\org\\day10\\cathode.txt";
        readFromFile(fileName);
    }

    public static void readFromFile(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                //String[] optLine = line.split("\n");
                System.out.println(line.substring(0,4));

            }
        } catch (IOException exception) {
            System.out.println("error");
        }
    }
    public static int cpu(String line) {
        String twoCycle = "addx";
        String oneCycle = "noop";
        int counter = 0;
        int value = 1;
        if (line.substring(0,4).equals(oneCycle)) {
            completeNoop(counter, value);
        } else if (line.substring(0,4).equals(oneCycle)) {
            completeAddx(counter);
        }
        return value;
    }

    public static int completeAddx (int counter) {
        return 0;
    }

    public static void completeNoop (int counter, int value) {
        counter += 1;
        value += 1;
    }
}
