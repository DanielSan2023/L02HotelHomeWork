import com.engeto.hotel.Booking;
import com.engeto.hotel.Guest;
import com.engeto.hotel.Room;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {


    public static void main(String[] args) {
        List<Guest> guests = new ArrayList<>();
        Room room1,room2,room3;

        Guest guest1 = new Guest("Adéla","Malíková",
                LocalDate.of(1993,03,13));
        Guest guest2 = new Guest("Ján","Dvoráček",
                LocalDate.of(1995,05,5));
//        guests.add(guest1);
//        guests.add(guest2);
        guest1.viewGuest();
        guest2.viewGuest();






        room1 = new Room(1,1,true,true,1000);
        room2 = new Room(2,1,true,true,1000);
        room3 = new Room(3,3,false,true,2400);
       room1.viewRoom();
      room2.viewRoom();
      room3.viewRoom();




//        // create booking
//        Booking booking1 = new Booking( guests,room3,
//                LocalDate.of(2021,7,19),
//                LocalDate.of(2021,7,26));
//        System.out.println(booking1.toString());


    }
}
