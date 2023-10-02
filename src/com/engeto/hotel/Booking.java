package com.engeto.hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private Guest guest,guest2,guest3;
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;
    private String typeOfVacation;

                // declaracion  'room' object class Room



    //region constructor


    public Booking(Guest guest, Guest guest2, Guest guest3, Room room, LocalDate startDate, LocalDate endDate) {
        this.guest = guest;
        this.guest2 = guest2;
        this.guest3 = guest3;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Booking(Guest guest, Guest guest2, Room room, LocalDate startDate, LocalDate endDate) {
        this.guest = guest;
        this.guest2 = guest2;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Booking(Guest guest, Room room, LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
        this.guest = guest;
    }

    public Booking(Guest guest, Room room) {
        this(guest,room,LocalDate.now(),LocalDate.now().plusDays(6));
    }
    //endregion


    @Override
    public String toString() {

        return "Booking1{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", room=" + room +
                ", guests=" + guest +", guests2=" + guest2 +
                '}';
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
