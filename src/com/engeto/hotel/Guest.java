package com.engeto.hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String formatDate(LocalDate dateOfBirth){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");

        // Formátovanie LocalDate na reťazec
        String formattedDate = dateOfBirth.format(formatter);
        return formattedDate;
    }
    public void viewGuest(){
        System.out.println(getFirstName() +" "+getLastName()+" "
        +formatDate(getDateOfBirth()));
    }

    @Override
    public String toString() {
        return "Guest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
