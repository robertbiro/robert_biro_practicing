package org.calorie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalorieCounting {
    public static void main(String[] args) {
        String fieName = "C:\\Users\\user\\Documents\\greenfox\\robert_biro_practicing\\src\\org\\calorie\\calorie.txt";
        readFromFile(fieName);
    }

    public static List<Integer> readFromFile(String fineName) {
        List<Integer> subTotal = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fineName));
            String line;
            int sum = 0;
            while ((line = reader.readLine()) != null) {
                if(line.isEmpty()) {
                    subTotal.add(sum);
                    sum = 0;
                } else {
                    int cal = Integer.parseInt(line);
                    sum += cal;
                }
            }
            reader.close();
            int max = Collections.max(subTotal);
            Collections.sort(subTotal, Collections.reverseOrder());
            System.out.println(subTotal);
            int resultOfFirstThree = 0;
            for (int i = 0; i < 3; i++)
                resultOfFirstThree += subTotal.get(i);
            System.out.println(resultOfFirstThree);
        } catch (IOException exception) {
            System.err.println("error");
        }
        return subTotal;
    }
}
