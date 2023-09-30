package com.engeto.hotel;

public class Room {
    private int roomNumber;
    private int numberOfBeds;
    private boolean Balcony;
    private boolean SeaView;
    private double pricePerNight;
    Room room;


    //region constructor

    public Room(int roomNumber, int numberOfBeds, boolean balcony, boolean seaView, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        Balcony = balcony;
        SeaView = seaView;
        this.pricePerNight = pricePerNight;
    }
    //endregion


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
}
