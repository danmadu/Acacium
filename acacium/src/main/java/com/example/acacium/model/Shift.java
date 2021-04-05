package com.example.acacium.model;

public class Shift {
    private String creator;
    private int BREAK;
    private String description;
    private String start;
    private String end;
    private String shiftType;

    public Shift() { }

    public Shift(String creator, int _break, String description, String start, String end, String shiftType) {
        this.end = end;
        this.start = start;
        this.description = description;
        this.creator = creator;
        this.shiftType = shiftType;
        this.BREAK = _break;
    }

    public Shift(String creator, int _break, String description, String start, String end) {
        this.end = end;
        this.start = start;
        this.description = description;
        this.creator = creator;
        this.shiftType = "";
        this.BREAK = _break;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getShiftType() {
        return shiftType;
    }

    public void setShiftType(String shiftType) {
        this.shiftType = shiftType;
    }

    public int getBREAK() {
        return BREAK;
    }

    public void setBREAK(int BREAK) {
        this.BREAK = BREAK;
    }

    // Overrides the tostring function
    @Override
    public String toString() {
        return "Creator: " + creator + ", Break: " + BREAK + ", Desc: " + description + ", Start: " + start + ", End: " + end + ", Shifttype: " + shiftType;
    }
}
