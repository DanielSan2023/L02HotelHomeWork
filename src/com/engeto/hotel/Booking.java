package com.engeto.hotel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private Guest mainGuest;

    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;
    private VacationType typeOfVacation; //Enum>REKREACNY, FIREMNY,RODINNY,SLUZOBNY
    private List<Guest> otherGuests;
   List<Booking> bookingAll = new ArrayList<>();






            //region constructors




    public Booking(Guest mainGuest, List<Guest> otherGuests, Room room,
                   LocalDate startDate, LocalDate endDate, VacationType typeOfVacation) {
        this.mainGuest = mainGuest;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.typeOfVacation = typeOfVacation;
        this.otherGuests = otherGuests; // Nastavíme zoznam ďalších hostí podľa zadaného zoznamu
        }

    public Booking(Guest mainGuest, Room room, LocalDate startDate, LocalDate endDate,
                   VacationType typeOfVacation) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
        this.mainGuest = mainGuest;
        this.typeOfVacation = typeOfVacation;
        this.otherGuests = new ArrayList<>();  // inicializuje zoznam hosti
    }

    public Booking(Guest mainGuest, Room room) {     //ak nezada datum automaticky dnesny + 6dni
        this(mainGuest,room,LocalDate.now(),LocalDate.now().plusDays(6),
                VacationType.REKREACNY);
    }

    public Booking(Guest mainGuest, Room room, VacationType typeOfVacation) {
        this(mainGuest,room,LocalDate.now(),LocalDate.now().plusDays(6),
                typeOfVacation);

    }

    public Booking() {

    }
    //endregions




    @Override
    public String toString() {
        if(otherGuests.isEmpty())
        return  "Pokoj cislo: "+room.getRoomNumber() +" termín od: " +startDate + " do " +endDate
                +". HlavnyHost: " + mainGuest +"druh pobytu: "+typeOfVacation;
        else return  "Pokoj cislo: "+room.getRoomNumber() +" termín od: " +startDate + " do " +endDate
                +". HlavnyHost: " + mainGuest + ", otherGuests=" + otherGuests+"druh pobytu: "+typeOfVacation;
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

    public Guest getMainGuest() {
        return mainGuest;
    }

    public void setMainGuest(Guest mainGuest) {
        this.mainGuest = mainGuest;
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

    public List<Guest> getOtherGuests() {
        return otherGuests;
    }

    public void setOtherGuests(List<Guest> otherGuests) {
        this.otherGuests = otherGuests;
    }


    public  void addBookingAllList(List<Booking> bookingList){

        this.bookingAll.addAll(bookingList);
    }




    public int getNumberOfGuests() { // vrati pocet hosti zo vsetkych rezervacii
        int guestCount = 0;
        for (Booking booking : bookingAll) {
            guestCount += booking.getNumberOfGuestsOfOneRezervation();
        }
        return guestCount;
    }

    public int getNumberOfGuestsOfOneRezervation() {   // vrati pocet hosti na konkretnu reyervaciu
        int guestCount = 0;
        if (mainGuest != null) {
            guestCount++; // Přidejte hlavního hosta z této rezervace
        }
        if (otherGuests != null) {
            guestCount += otherGuests.size(); // Přidejte počet dalších hostů z této rezervace
        }
        return guestCount;
    }

    public long getBookingLength(){
        LocalDate start =   startDate;
        LocalDate end =endDate;
        long daysBetween = ChronoUnit.DAYS.between(start, end);

        return daysBetween;
    }

    public long getPrice(){
        return (long) (getBookingLength() * getRoom().getPricePerNight());

    }


}
