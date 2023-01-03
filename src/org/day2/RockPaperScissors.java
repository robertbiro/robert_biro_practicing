package org.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RockPaperScissors {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\user\\Documents\\greenfox\\robert_biro_practicing\\src\\org\\day2\\RockPaperScissors.java";
        readFromFile(fileName);
    }
    public static char [] readFromFile(String fileName) {
       char [] gameChar = new char[2];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                int sum = 0;
                int result = 0;
                gameChar = line.replace(" ", "").toCharArray();
                System.out.println(line);
                sum = game(gameChar);
                result += sum;
                System.out.println(result);
            }
            reader.close();
        } catch (IOException exception) {
            System.out.println("Error!");
        }
        return gameChar;
    }

    public static HashMap<String, Integer> scoresOfGame() {
        HashMap<String, Integer> scores = new HashMap<>();
        scores.put("A", 1); //rock
        scores.put("B", 2); //paper
        scores.put("C",3);  //Scissors
        scores.put("X", 1); //rock
        scores.put("Y", 2); //paper
        scores.put("L",0);  //lost
        scores.put("W",6);  //win
        scores.put("D",3);  //drawn
        return scores;
    }

    public static int game(char [] gameChar) {
        HashMap<String, Integer> scores = scoresOfGame();
        int [] valueOfItem = new int[3];
        int sumOfOneGame = 0;
        for (int i = 0; i < gameChar.length; i++) {
            for (Map.Entry<String, Integer> entry : scores.entrySet()) {
                if (entry.getKey().equals(String.valueOf(gameChar[i]))) {
                    valueOfItem[i] = entry.getValue();
                    System.out.println(valueOfItem[i]);
                }
                if (valueOfItem[0] > valueOfItem[1]) {
                    valueOfItem[2] = scores.get("L");
                } else if (valueOfItem[0] < valueOfItem[1]) {
                    valueOfItem[2] = scores.get("W");
                } else {
                    valueOfItem[2] = scores.get("D");
                }
                for (int j = 0; j < valueOfItem.length; j++) {
                    System.out.println(valueOfItem[j]);
                    sumOfOneGame += valueOfItem[j];
                }
            }
        }
        return sumOfOneGame;
    }
}
