package com.example.acacium.dao;

import com.example.acacium.model.Shift;

import java.util.List;

public interface ShiftDAO {
    int insertShift(String creator, int _break, String description, String start, String end, String shiftType);

    int insertMultipleShifts(List<Shift> shifts);

    List<Shift> retrieveAllShifts();
}
