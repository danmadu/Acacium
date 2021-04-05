package com.example.acacium.dao;

import com.example.acacium.model.Shift;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository("shiftList")
public class ShiftDataAccessService implements ShiftDAO {
    // stores the shifts in a list
    private List<Shift> shiftList = new ArrayList<>();

    @Override
    public int insertShift(String creator, int _break, String description, String start, String end, String shiftType) {
        // inserts the shift into the list and returns 1
        this.shiftList.add(new Shift(creator, _break, description, start, end, shiftType));
        return 1;
    }

    public int insertMultipleShifts(List<Shift> shifts) {
        // inserts multiple shifts into the list and returns 1
        this.shiftList.addAll(shifts);
        return 1;
    }

    @Override
    public List<Shift> retrieveAllShifts() {
        // filters out all the blank shifttypes then returns the shift list
        return this.shiftList.stream().filter(shift -> !shift.getShiftType().equals("")).collect(Collectors.toList());
    }
}
