package com.engeto.hotel;

import java.util.List;

public class BookingManager {

    List<Booking> bookingList;



        // prida rezervaciu do bookingListu
    public  void addBooking(Booking newBooking){
    bookingList.add(newBooking);
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




}
