import com.engeto.hotel.Booking;
import com.engeto.hotel.Guest;
import com.engeto.hotel.Room;


import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


public class Main {


    public static void main(String[] args) {
        List<Guest> guestForBooking2 = new ArrayList<>();
        Room room1,room2,room3;


   //1.zadanie vytvor hosti a vypis na obrazovku
        Guest guest1 = new Guest("Adéla","Malíková",
                LocalDate.of(1993,03,13));
        Guest guest2 = new Guest("Ján","Dvoráček",
                LocalDate.of(1995,05,5));
        guest1.viewGuest();
        guest2.viewGuest();
        guestForBooking2.add(guest1);
        guestForBooking2.add(guest2);





    // 2.zadanie  vytvor izby a vypis na obrazovku
        room1 = new Room(1,1,true,true,1000);
        room2 = new Room(2,1,true,true,1000);
        room3 = new Room(3,3,false,true,2400);
       room1.viewRoom();
      room2.viewRoom();
      room3.viewRoom();




        // 3.zadanie vytvorim rezervaciu
        Booking booking1 = new Booking(guestForBooking2,room3,
                LocalDate.of(2021,7,19),
                LocalDate.of(2021,7,26));


        //4.zadanie zoznam rezervacii
        List<Booking> bookings = new ArrayList<>();
        bookings.add(booking1);

        System.out.println("Seznam rezervací:");
        for (Booking booking : bookings) {
            System.out.println(booking);


    }
}}
