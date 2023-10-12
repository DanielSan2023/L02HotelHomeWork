package com.engeto.hotel;

import java.util.ArrayList;
import java.util.List;

public class BookingManager {

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



}
