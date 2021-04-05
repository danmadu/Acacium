package com.example.acacium.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShiftTest {

    @Test
    public void testShiftCreation() {
        Shift shift = new Shift();

        shift.setBREAK(60);
        shift.setShiftType("early");
        shift.setCreator("ea2da28f-9dae-430c-be68-9c35f06e0ff1");
        shift.setDescription("Community Nurse Required - Early - W1 - 13:32");
        shift.setEnd("2018-03-22T15:30:00.000Z");
        shift.setStart("2018-03-22T07:00:00.000Z");

        assertEquals(60, shift.getBREAK());
        assertEquals("early", shift.getShiftType());
        assertEquals("ea2da28f-9dae-430c-be68-9c35f06e0ff1", shift.getCreator());
        assertEquals("Community Nurse Required - Early - W1 - 13:32", shift.getDescription());
        assertEquals("2018-03-22T15:30:00.000Z", shift.getEnd());
        assertEquals("2018-03-22T07:00:00.000Z", shift.getStart());
    }
}