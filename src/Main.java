import com.engeto.hotel.Booking;
import com.engeto.hotel.Guest;
import com.engeto.hotel.Room;
import com.engeto.hotel.VacationType;


import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


public class Main {


    public static void main(String[] args) {
        List<Guest> guestForBooking2 = new ArrayList<>();
        Room room1,room2,room3;  // 3 premenne typu Room
        Guest guest1,guest2,guest3;   // 3 premenne typu Guest

   //1.zadanie vytvor hosti a vypis na obrazovku
         guest1 = new Guest("Adéla","Malíková",
                LocalDate.of(1993,03,13));
         guest2 = new Guest("Ján","Dvoráček",
                LocalDate.of(1995,05,5));
         guest3 = new Guest("Eugen","Ptáček",
                LocalDate.of(1991,03,7));
        guestForBooking2.add(guest1);
        guestForBooking2.add(guest2);
        guestForBooking2.add(guest3);
        System.out.println("Hostia: ");
        guest1.getDescription();
        guest2.getDescription();
        guest3.getDescription();







    // 2.zadanie  vytvor izby a vypis na obrazovku
        room1 = new Room(1,1,true,true,1000);
        room2 = new Room(2,1,true,true,1000);
        room3 = new Room(3,3,false,true,2400);
        System.out.println("Hotelove pokoje: ");
        room1.viewRoom();
        room2.viewRoom();
        room3.viewRoom();




        // 3.zadanie vytvorim rezervaciu
        Booking booking1 = new Booking(guest1,room3,
                LocalDate.of(2021,7,19),
                LocalDate.of(2021,7,26), VacationType.REKREACNY);


        // Rezervácia s ďalšími hosťami
        List<Guest> otherGuests = new ArrayList<>();
        otherGuests.add(guest2);
        Booking booking2 = new Booking(guest1, otherGuests,room1,
                LocalDate.of(2021,9,1),
                LocalDate.of(2021,9,14),VacationType.FIREMNY);

        Booking booking3 = new Booking(guest3,room2,VacationType.FIREMNY);
        Booking booking4 = new Booking(guest3,room2);

        //4.zadanie zoznam rezervacii
        List<Booking> bookings = new ArrayList<>();
        bookings.add(booking1);
        bookings.add(booking2);
        bookings.add(booking3);
        bookings.add(booking4);

        //vypis seznam rezervaci
        System.out.println("Seznam rezervací:");
        for (Booking booking : bookings) {
            System.out.println(booking);


    }
}}
