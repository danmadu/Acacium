package com.example.acacium.service;

import com.example.acacium.dao.ShiftDAO;
import com.example.acacium.model.Shift;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ShiftServiceTest {

    private ShiftDAO shiftDAO;
    private ShiftService shiftService;
    private Shift shift;

    @BeforeEach
    public void init() {
        // Creating a mock shiftDAO repository
        shiftDAO = mock(ShiftDAO.class);
        shiftService = new ShiftService(shiftDAO);
        shift = new Shift();

        shift.setBREAK(60);
        shift.setShiftType("early");
        shift.setCreator("ea2da28f-9dae-430c-be68-9c35f06e0ff1");
        shift.setDescription("Community Nurse Required - Early - W1 - 13:32");
        shift.setEnd("2018-03-22T15:30:00.000Z");
        shift.setStart("2018-03-22T07:00:00.000Z");
    }

    @Test
    public void testInsertShift() {
        when(shiftDAO.insertShift(shift.getCreator(), shift.getBREAK(), shift.getDescription(), shift.getStart(), shift.getEnd(), shift.getShiftType())).thenReturn(1);
        assertEquals(1, shiftService.insertShift(shift.getCreator(), shift.getBREAK(), shift.getDescription(), shift.getStart(), shift.getEnd(), shift.getShiftType()));
    }

    @Test
    public void testRetrieveAllShifts() {
        when(shiftDAO.insertShift(shift.getCreator(), shift.getBREAK(), shift.getDescription(), shift.getStart(), shift.getEnd(), shift.getShiftType())).thenReturn(1);
        shiftService.insertShift(shift.getCreator(), shift.getBREAK(), shift.getDescription(), shift.getStart(), shift.getEnd(), shift.getShiftType());
        List<Shift> shiftList = new ArrayList<>();
        shiftList.add(shift);
        when(shiftDAO.retrieveAllShifts()).thenReturn(shiftList);
        assertEquals(shiftList, shiftService.retrieveAllShifts());
    }

    @Test
    public void testInsertMultipleShifts() {
        List<Shift> shiftList = new ArrayList<>();
        shiftList.add(shift);
        when(shiftDAO.insertMultipleShifts(shiftList)).thenReturn(1);
        assertEquals(1, shiftDAO.insertMultipleShifts(shiftList));
    }

}