import com.engeto.hotel.*;


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

        // Rezervácia s ďalšími hosťami
        List<Guest> otherGuests = new ArrayList<>();
        otherGuests.add(guest2);
        otherGuests.add(guest3);


        // 3.zadanie vytvorim rezervaciu
        Booking booking1 = new Booking(guest1,room3,
                LocalDate.of(2021,7,19),
                LocalDate.of(2021,7,26), VacationType.REKREACNY);
        Booking booking2 = new Booking(guest1, otherGuests,room1,
                LocalDate.of(2021,9,1),
                LocalDate.of(2021,9,14),VacationType.FIREMNY);
        Booking booking3 = new Booking(guest3,room2,VacationType.FIREMNY);
        Booking booking4 = new Booking(guest2,room2,VacationType.PRACOVNY);

        Booking booking5 = new Booking(guest1, otherGuests,room1,
                LocalDate.of(2021,9,1),
                LocalDate.of(2021,9,14),VacationType.FIREMNY);
        Booking booking6 = new Booking(guest1, otherGuests,room1,
                LocalDate.of(2021,9,1),
                LocalDate.of(2021,9,14),VacationType.PRACOVNY);

        //4.zadanie zoznam rezervacii
        List<Booking> bookings = new ArrayList<>();
        bookings.add(booking1);
        bookings.add(booking2);
        bookings.add(booking3);
        bookings.add(booking4);
        bookings.add(booking5);
        bookings.add(booking6);

       //   vypis seznam rezervaci
        System.out.println("Seznam rezervací:");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }




            //----------------------Lekcie 3 HomeWork-----------------------------//
            System.out.println("-------Lekcie 3 HomeWork---------------");
            BookingManager newBooking = new BookingManager();

            newBooking.addBookingList(bookings);
             System.out.println( "Pracovny pobyt : "+newBooking.getNumberOfWorkingBookings());


        Booking bookingAllList = new Booking();
        // posielam vsetky rezervacie do bookingAll
        bookingAllList.addBookingAllList(bookings);
        System.out.println("Pocet vsetkych hosti: "+ bookingAllList.getNumberOfGuests());
        System.out.println("Pocet vsetkych rezervacii:"+newBooking.getNumberOfRezervations());
        System.out.println("Priemerny pocet hosti na rezervaciu: " +newBooking.getAverageGuests(bookingAllList.getNumberOfGuests()));


    }
}
