package com.engeto.hotel;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private Guest guest,guest2,guest3;
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;
    private VacationType typeOfVacation; //Enum>REKREACNY, FIREMNY,RODINNY,SLUZOBNY




            //region constructor


    public Booking(Guest guest, Guest guest2, Guest guest3, Room room, LocalDate startDate, LocalDate endDate,VacationType typeOfVacation) {
        this.guest = guest;
        this.guest2 = guest2;
        this.guest3 = guest3;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.typeOfVacation = typeOfVacation;
    }

    public Booking(Guest guest, Guest guest2, Room room, LocalDate startDate, LocalDate endDate,VacationType typeOfVacation) {
        this.guest = guest;
        this.guest2 = guest2;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.typeOfVacation = typeOfVacation;
    }

    public Booking(Guest guest, Room room, LocalDate startDate, LocalDate endDate,VacationType typeOfVacation) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
        this.guest = guest;
        this.typeOfVacation = typeOfVacation;
    }

    public Booking(Guest guest, Room room) {     //ak nezada datum automaticky dnesny + 6dni
        this(guest,room,LocalDate.now(),LocalDate.now().plusDays(6),
                VacationType.REKREACNY);
    }

    public Booking(Guest guest, Room room, VacationType typeOfVacation) {
        this(guest,room,LocalDate.now(),LocalDate.now().plusDays(6),typeOfVacation);

    }
    //endregion


    @Override
    public String toString() {  // kontrola poctu hosti
        if(guest2==null && guest3==null)
        {return "Pokoj cislo: "+room.getRoomNumber() +" termín od :" +startDate + " do " +endDate
                +". Host: " +guest + "druh pobytu: "+typeOfVacation;}
        else if(guest3==null){return "Pokoj cislo: "+room.getRoomNumber() +" termín od :" +startDate + " do " +endDate // 2hostia
                +". Hostia:" +guest +" a "+guest2 + "druh pobytu: "+typeOfVacation;}
        else return "Pokoj cislo: "+room.getRoomNumber() +" termín od :" +startDate + " do " +endDate
                    +". Hostia:"  +guest +" a "+guest2 +" a "+guest3 + "druh pobytu: "+typeOfVacation; //3 hostia
    }

            //region Get a Setter
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

    public VacationType getTypeOfVacation() {
        return typeOfVacation;
    }

    public void setTypeOfVacation(VacationType typeOfVacation) {
        this.typeOfVacation = typeOfVacation;
    }
    //endregion
}
