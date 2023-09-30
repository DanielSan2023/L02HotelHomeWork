package com.engeto.hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private LocalDate startDate;
    private LocalDate endDate;
    private String typeOfVacation;

    private Room room;             // declaracion  'room' object class Room
    private List<Guest> guests;   // guest is list about people whose were in the room


    //region constructor

    public Booking( List<Guest> guests,Room room,LocalDate startDate, LocalDate endDate ) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
        this.guests = guests;
    }

    //endregion


    @Override
    public String toString() {
        return "Booking1{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", room=" + room +
                ", guests=" + guests +
                '}';
    }
}
