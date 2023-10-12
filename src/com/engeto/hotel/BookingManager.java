package com.engeto.hotel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    Booking booking = new Booking();
    List<Booking> bookingList = new ArrayList<>();



        // prida rezervaciu do bookingListu
    public  void addBooking(Booking newBooking){

        bookingList.add(newBooking);
    }

    public  void addBookingList(List<Booking> bookingList){
      this.bookingList.addAll(bookingList);
    }
            // vrati rezervaciu podla indexu
    public Booking getBooking(int index){
        if (index >= 0 && index < bookingList.size())
        {
            return bookingList.get(index);
        }
        return null; // Index je mimo rozsah seznamu
    }

    //vrati seznam  bookingList rezervacii
    public List<Booking> getBookings(){
        return   bookingList;
    }
    public int  getNumberOfRezervations(){
        return   bookingList.size();
    }

        //remove bookingList -- clear all reservation
    public void clearBookings(){
        bookingList.clear();
    }


    public int getNumberOfWorkingBookings(){
        int count = 0;
        for (Booking booking : bookingList) {
           if(booking.getTypeOfVacation()==VacationType.PRACOVNY) {count++;}
        }
        return count;
    }

    public BigDecimal getAverageGuests(int numberOfGuest){


        if (bookingList.size() > 0) {
            BigDecimal averageGuests = BigDecimal.valueOf(numberOfGuest)
                    .divide(BigDecimal.valueOf(bookingList.size()),
                            2, RoundingMode.HALF_UP);
            return averageGuests;
        } else {
            return BigDecimal.ZERO;
        }
    }



}
