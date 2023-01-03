package org.day9;

public class Head {

    private int headXCoordinate;
    private int headYCoordinate;
    private boolean startCoordinateOfHead;
    private boolean endCoordinateOfHead;

    private char direction;

    public Head() {
    }

    public int getHeadXCoordinate() {
        return headXCoordinate;
    }

    public void setHeadXCoordinate(int headXCoordinate) {
        this.headXCoordinate = headXCoordinate;
    }

    public int getHeadYCoordinate() {
        return headYCoordinate;
    }

    public void setHeadYCoordinate(int headYCoordinate) {
        this.headYCoordinate = headYCoordinate;
    }

    public boolean isStartCoordinateOfHead() {
        return startCoordinateOfHead;
    }

    public void setStartCoordinateOfHead(boolean startCoordinateOfHead) {
        this.startCoordinateOfHead = startCoordinateOfHead;
    }

    public boolean isEndCoordinateOfHead() {
        return endCoordinateOfHead;
    }

    public void setEndCoordinateOfHead(boolean endCoordinateOfHead) {
        this.endCoordinateOfHead = endCoordinateOfHead;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }
}
