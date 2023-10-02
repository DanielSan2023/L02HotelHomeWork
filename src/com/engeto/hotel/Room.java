package com.engeto.hotel;

public class Room {
    private int roomNumber;
    private int numberOfBeds;
    private boolean Balcony;
    private boolean SeaView;
    private double pricePerNight;



    //region constructor

    public Room(int roomNumber, int numberOfBeds, boolean balcony, boolean seaView, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        Balcony = balcony;
        SeaView = seaView;
        this.pricePerNight = pricePerNight;
    }
    //endregion


    public boolean isBalcony() {
        return Balcony;
    }

    public void setBalcony(boolean balcony) {
        Balcony = balcony;
    }

    public boolean isSeaView() {
        return SeaView;
    }

    public void setSeaView(boolean seaView) {
        SeaView = seaView;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                '}';
    }

    public void viewRoom(){
         System.out.println(
                 "Číslo izby: "+roomNumber +
                 " počet postelí: "+ numberOfBeds +
                 " cena za noc:  " +pricePerNight+" CK"+
          (isBalcony()?" s balkónom a  ":" bez balkona a "   )
          + (isSeaView()?"  s vyhladom na more": " ")
         );

    }
}

