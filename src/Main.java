import com.engeto.hotel.Booking;
import com.engeto.hotel.Guest;
import com.engeto.hotel.Room;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {


    public static void main(String[] args) {
        Room room1,room2,room3;

        Guest guest1 = new Guest("Adéla","Malíková", LocalDate.of(1993,03,13));
        room1 = new Room(1,1,true,true,1000);
        room2 = new Room(2,1,true,true,1000);
        room3 = new Room(3,3,false,true,2400);

        List<Guest> guests = new ArrayList<>();
        guests.add(guest1);

        // create booking
        Booking booking1 = new Booking( guests,room1,
                LocalDate.of(2021,7,19),
                LocalDate.of(2021,7,26));
        System.out.println(booking1.toString());


    }
}
