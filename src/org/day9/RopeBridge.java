package org.day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class RopeBridge {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\user\\Documents\\greenfox\\robert_biro_practicing\\src\\org\\day9\\input.txt";
        readFromFile(fileName);
    }

    public static void readFromFile (String fileName) {
        ArrayList<ArrayList<int[]>> allCoordinatesOfHead = new ArrayList<>();
        Head head = new Head();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null ) {
                String direction =  line.replace(" ", "");
                ArrayList<int[]> allCoordinatesOfOneMovement = new ArrayList<>();
                getMovingOfHead(direction, head);
            }
        } catch (IOException exception) {
            System.out.println("error");
        }
    }

    public static int[] getMovingOfHead (String direction, Head head) {
        int[] oneMovementOfHead = new  int[2];
        //only the current step -> Head always moves only in horizontal or vertical direction, so
        //one variable is always null.
        oneMovementOfHead [0] = 0;
        oneMovementOfHead [1] = 0;
        switch (direction.charAt(0)) {
            case 'R':
                oneMovementOfHead[0] = Integer.parseInt(direction.substring(1,2));
                head.setDirection('R');
                getCoordinatesOfOneMovementOfHead(oneMovementOfHead, head);
                break;
            case 'L':
                oneMovementOfHead[0] = -Integer.parseInt(direction.substring(1,2));
                head.setDirection('L');
                getCoordinatesOfOneMovementOfHead(oneMovementOfHead, head);
                break;
            case 'U':
                oneMovementOfHead[1] = Integer.parseInt(direction.substring(1,2));
                head.setDirection('U');
                getCoordinatesOfOneMovementOfHead(oneMovementOfHead, head);
                break;
            case 'D':
                oneMovementOfHead[1] = -Integer.parseInt(direction.substring(1,2));
                head.setDirection('D');
                getCoordinatesOfOneMovementOfHead(oneMovementOfHead, head);
                break;
            default:
                System.out.println("error");
        }
        return oneMovementOfHead ;
    }

    public static void getCoordinatesOfOneMovementOfHead(int[] oneMovementOfHead, Head head) {
        int directionAndValue = ((oneMovementOfHead[0] == 0)? oneMovementOfHead[1] : oneMovementOfHead[0]);
        for (int i = 1; i <= Math.abs(directionAndValue); i++) {
            markStatusOfHead(i, directionAndValue, head);
            int[] coordinatesOfOneMovement = new int[2];
            if (directionAndValue == oneMovementOfHead[0]) {
                if (directionAndValue > 0) {
                    coordinatesOfOneMovement[0] = head.getHeadXCoordinate() + 1;
                } else {
                    coordinatesOfOneMovement[0] = head.getHeadXCoordinate() - 1;
                }
                coordinatesOfOneMovement[1] = head.getHeadYCoordinate();
            } else {
                if (directionAndValue > 0) {
                    coordinatesOfOneMovement[1] = head.getHeadYCoordinate() + 1;
                } else {
                    coordinatesOfOneMovement[1] = head.getHeadYCoordinate() - 1;
                }
                coordinatesOfOneMovement[0] = head.getHeadXCoordinate();
            }
            head.setHeadXCoordinate(coordinatesOfOneMovement[0]);
            head.setHeadYCoordinate(coordinatesOfOneMovement[1]);
            System.out.println(head.getHeadXCoordinate() + " : " + head.getHeadYCoordinate() + " : " + head.isEndCoordinateOfHead() + " : " + head.getDirection());
        }
    }

    public static void markStatusOfHead(int index, int directionAndValue, Head head) {
        if (index == 1) {
            head.setStartCoordinateOfHead(true);
        } else {
            head.setStartCoordinateOfHead(false);
        }
        if (index == directionAndValue) {
            head.setEndCoordinateOfHead(true);
        } else {
            head.setEndCoordinateOfHead(false);
        }
    }
}
