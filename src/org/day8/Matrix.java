package org.day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Matrix {


    public ArrayList<ArrayList<Item>> readFromFile(String fileName) {
        ArrayList<ArrayList<Item>> matrix = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                ArrayList<String> stringRowOfMatrix = new ArrayList<>(Arrays.asList(line.split("")));
                ArrayList<Item> rowOfMatrix = new ArrayList<>();
                for (String s : stringRowOfMatrix) {
                    Integer number = Integer.parseInt(s);
                    Item item = new Item(number);
                    rowOfMatrix.add(item);
                }
                matrix.add(rowOfMatrix);
            }
        } catch (IOException exception) {
            System.out.println("error");
        }
        return matrix;
    }

    public void getMaxFromRowOfMatrix (ArrayList<ArrayList<Item>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            int index = 0;
            Item currentMaxItem = new Item();
            currentMaxItem.setNumber(matrix.get(i).get(index).getNumber());
            currentMaxItem.setInvolved(matrix.get(i).get(index).isInvolved());
            while (index < matrix.get(i).size()) {
                if (index == 0 || matrix.get(i).get(index).getNumber() > currentMaxItem.getNumber()){
                    currentMaxItem.setNumber(matrix.get(i).get(index).getNumber());
                    matrix.get(i).get(index).setInvolved(true);
                }
                index++;
            }
        }
    }
    public void rotateMatrixInRight(ArrayList<ArrayList<Item>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = i; j < matrix.get(i).size(); j++) {
                Item tempForTranspose = new Item();
                tempForTranspose.setNumber(matrix.get(i).get(j).getNumber());
                tempForTranspose.setInvolved(matrix.get(i).get(j).isInvolved());
                //---------------------------------------------------
                matrix.get(i).get(j).setNumber(matrix.get(j).get(i).getNumber());
                matrix.get(i).get(j).setInvolved(matrix.get(j).get(i).isInvolved());
                //---------------------------------------------------
                matrix.get(j).get(i).setNumber(tempForTranspose.getNumber());
                matrix.get(j).get(i).setInvolved(tempForTranspose.isInvolved());
            }
        }
        for (int i = 0; i < matrix.size(); i++) {
            int low = 0, high = matrix.get(i).size() - 1;
            while (low < high) {
                Item tempForSwap = new Item();
                tempForSwap.setNumber(matrix.get(i).get(low).getNumber());
                tempForSwap.setInvolved(matrix.get(i).get(low).isInvolved());
                //---------------------------------------------------
                matrix.get(i).get(low).setNumber(matrix.get(i).get(high).getNumber());
                matrix.get(i).get(low).setInvolved(matrix.get(i).get(high).isInvolved());
                //---------------------------------------------------
                matrix.get(i).get(high).setNumber(tempForSwap.getNumber());
                matrix.get(i).get(high).setInvolved(tempForSwap.isInvolved());
                low++;
                high--;
            }
        }
    }

    public void getAllSumOfVisibleTree (String fileName) {
        ArrayList<ArrayList<Item>> matrix = readFromFile(fileName);
        for (int i = 0; i < 4; i++) {
            rotateMatrixInRight(matrix);
            getMaxFromRowOfMatrix(matrix);
            //printMatrix(matrix);
        }
        int numberOfInvolvedTree = getNumberOfInvolvedTree(matrix);
        System.out.println(numberOfInvolvedTree);
    }

    public Integer getNumberOfInvolvedTree (ArrayList<ArrayList<Item>> matrix) {
        int numberOfInvolvedTree = 0;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if(matrix.get(i).get(j).isInvolved()) {
                    numberOfInvolvedTree ++;
                }
            }
        }
        return numberOfInvolvedTree;
    }
    public void printMatrix (ArrayList<ArrayList<Item>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                System.out.print(matrix.get(i).get(j).getNumber() + " : " + matrix.get(i).get(j).isInvolved()+ " " + "\t");
            }
            System.out.println();
        }
    }
}
