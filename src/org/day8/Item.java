package org.day8;

public class Item {
    private Integer number;
    private boolean isInvolved;

    public Item(Integer number) {
        this.number = number;
        this.isInvolved = false;
    }

    public Item() {
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public boolean isInvolved() {
        return isInvolved;
    }

    public void setInvolved(boolean involved) {
        isInvolved = involved;
    }
}
