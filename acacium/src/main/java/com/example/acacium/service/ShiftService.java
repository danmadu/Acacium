package com.example.acacium.service;

import com.example.acacium.dao.ShiftDAO;
import com.example.acacium.model.Shift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftService {
    private ShiftDAO shiftDAO;

    @Autowired
    public ShiftService(@Qualifier("shiftList") ShiftDAO shiftDAO) {
        this.shiftDAO = shiftDAO;
    }

    public int insertMultipleShifts(List<Shift> shifts) {
        return this.shiftDAO.insertMultipleShifts(shifts);
    }

    public int insertShift(String creator, int _break, String description, String start, String end, String shiftType) {
        return this.shiftDAO.insertShift(creator, _break, description, start, end, shiftType);
    }

    public List<Shift> retrieveAllShifts() {
        return this.shiftDAO.retrieveAllShifts();
    }
}
