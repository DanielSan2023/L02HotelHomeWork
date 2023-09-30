package com.engeto.hotel;

import java.time.LocalDate;
import java.util.List;

public class Guest  {
    private  String firstName;
    private  String lastName;
    private  LocalDate dateOfBirth;

    //region constructor

    public Guest(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }


    //endregion


    @Override
    public String toString() {
        return "Guest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
