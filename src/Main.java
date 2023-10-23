import com.engeto.hotel.*;


import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Main {


    public static void main(String[] args) {
        List<Guest> guestForBooking2 = new ArrayList<>();
        Room room1, room2, room3;  // 3 premenne typu Room
        Guest guest1, guest2, guest3;   // 3 premenne typu Guest


        //1.zadanie vytvor hosti a vypis na obrazovku
        guest1 = new Guest("Adéla", "Malíková",
                LocalDate.of(1993, 03, 13));
        guest2 = new Guest("Ján", "Dvoráček",
                LocalDate.of(1995, 05, 5));
        guest3 = new Guest("Eugen", "Ptáček",
                LocalDate.of(1991, 03, 7));
        guestForBooking2.add(guest1);
        guestForBooking2.add(guest2);
        guestForBooking2.add(guest3);

        System.out.println("Hostia: ");
        guest1.getDescription();
        guest2.getDescription();
        guest3.getDescription();


        // 2.zadanie  vytvor izby a vypis na obrazovku
        room1 = new Room(1, 1, true, true, 1000);
        room2 = new Room(2, 1, true, false, 1000);
        room3 = new Room(3, 3, false, true, 2400);
        System.out.println("Hotelove pokoje: ");
        room1.viewRoom();
        room2.viewRoom();
        room3.viewRoom();

        // Rezervácia s ďalšími hosťami
        List<Guest> otherGuests = new ArrayList<>();
        otherGuests.add(guest2);
        otherGuests.add(guest3);
        List<Guest> otherGuests2 = new ArrayList<>();
        otherGuests2.add(guest3);
        List<Guest> otherGuests3 = new ArrayList<>();
        otherGuests3.add(guest2);



        // 3.zadanie vytvorim rezervaciu
        Booking booking1 = new Booking(guest1, room3,
                LocalDate.of(2021, 7, 19),
                LocalDate.of(2021, 7, 26), VacationType.REKREACNY);
        Booking booking2 = new Booking(guest1, otherGuests, room1,
                LocalDate.of(2021, 7, 14),
                LocalDate.of(2021, 9, 1), VacationType.FIREMNY);
        Booking booking3 = new Booking(guest3, room3, VacationType.FIREMNY);
        Booking booking4 = new Booking(guest2, room2, VacationType.PRACOVNY);
        Booking booking5 = new Booking(guest1, otherGuests2, room1,
                LocalDate.of(2021, 5, 1),
                LocalDate.of(2021, 9, 14), VacationType.FIREMNY);
        Booking booking6 = new Booking(guest1, otherGuests3, room2,
                LocalDate.of(2021, 6, 1),
                LocalDate.of(2021, 7, 14), VacationType.PRACOVNY);

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
        newBooking.addBookingList(bookings); // pridal som vsetky rezervacie do triedy BookingManager
        int indexListuBooking = 1;
        System.out.println("Vypise rezervaciu podla indexu: (" + indexListuBooking + ") --> " + newBooking.getBooking(0));
        System.out.println("Vypise vsetky rezervacie z BookingManagera :");
        for (Booking booking : newBooking.getBookings()) {
            System.out.println(booking.toString());
        }

        //----------------------Počet pracovních pobytů-------------------------------//
        System.out.println("Počet pracovných pobytov : " + newBooking.getNumberOfWorkingBookings());

        //--------------------  Průměrný počet hostů na rezervaci   ---------------------//
        Booking bookingAllList = new Booking();
        // posielam vsetky rezervacie do bookingAll
        bookingAllList.addBookingAllList(bookings);
        System.out.println("Pocet vsetkych hosti: " + bookingAllList.getNumberOfGuests());
        System.out.println("Pocet vsetkych rezervacii:" + newBooking.getNumberOfRezervations());
        System.out.println("Priemerny pocet hosti na rezervaciu: " + newBooking.getAverageGuests(bookingAllList.getNumberOfGuests()));

        //-------------------Vytvoření testovacích dat----------------------------------//
        List<Booking> bookingsForTest = new ArrayList<>();

        bookingsForTest.add(new Booking(new Guest("Karel"," Dvorak" ,
                LocalDate.of(1990, 05, 15)),room3,
                LocalDate.of(2023, 6, 1),
                LocalDate.of(2023, 6, 7),VacationType.PRACOVNY));
        bookingsForTest.add(new Booking(new Guest("Karel"," Dvorak" ,
                LocalDate.of(1979, 05, 15)),room2,
                LocalDate.of(2023, 7, 18),
                LocalDate.of(2023, 7, 21),VacationType.REKREACNY));

        // Karolina  si rezervuje 10 dvou dennzych rezervacii
        Guest karolina = new Guest("Karolína", "Tmavá",
                       LocalDate.of(1990, 1, 1));
        LocalDate startDate = LocalDate.of(2023, 8, 1);
        LocalDate endDate = LocalDate.of(2023, 8, 2);
        for (int i = 0; i < 10; i++) {
               Booking karolinaBooking = new Booking(karolina, room2, startDate, endDate, VacationType.REKREACNY);
               bookingsForTest.add(karolinaBooking);
               // posunie datum o 2 dni dopredu
            startDate = startDate.plusDays(2);
            endDate = endDate.plusDays(2);
        }

        Booking karolinaBooking = new Booking(karolina, room3,
                LocalDate.of(2023, 8, 1),
                LocalDate.of(2023, 8, 31), VacationType.REKREACNY);
        bookingsForTest.add(karolinaBooking);
            // pomocou metody posle  rezervacie do bookingListu
        fillBookings(newBooking,bookingsForTest);


        // vypise zoznam rezervacii z BookingManagera
        List<Booking> allBookings = newBooking.getBookings();
        printBookings(allBookings);

        // vypise prvych limit=8 rezervacii Typu ? REKREACNY
        printRekreacnyTypOfRezervation(8,allBookings);

        printGuestStatistics(allBookings);
        System.out.println("Pocet vsetkých rezervacii :  "+newBooking.getNumberOfRezervations() );

        // Analyza  poctu rezervacii podla mesiacov 2023
        printRezervationsStatisticsPerYear(allBookings);


    }

    private static void printRezervationsStatisticsPerYear(List<Booking> allBookings) {
        Map<Month, Integer> reservationsPerMonth = new HashMap<>();
        Map<Month, Float> pricePerMonth = new HashMap<>();
        for (Booking booking : allBookings) {
            LocalDate startDate1 = booking.getStartDate();
            Month startMonth = startDate1.getMonth();
            // Ak mesiac ešte nie je v mape, tak init hodnota 1, inak zvýšim počet rezervácií pre daný mesiac
            reservationsPerMonth.put(startMonth, reservationsPerMonth.getOrDefault(startMonth, 0) + 1);
            pricePerMonth.put(startMonth, (float) (pricePerMonth.getOrDefault(startMonth, 0f) + booking.getRoom().getPricePerNight()));}

        for (Month month : Month.values()) {
            int count = reservationsPerMonth.getOrDefault(month, 0);
            float revenue = pricePerMonth.getOrDefault(month, 0f);

            System.out.println("2023 " + month + ": " + count + " rezervácií, " + "Celková cena: " + revenue + " CZK");
        }
    }

    private static void printGuestStatistics(List<Booking> allBookings) {
        int pocetRez1Host=0;
        int pocetRez2Host=0;
        int pocetRezViacHost=0;
        for (Booking booking : allBookings) {
            if(booking.getNumberOfGuestsOfOneRezervation()==1){ pocetRez1Host++;}
            if(booking.getNumberOfGuestsOfOneRezervation()==2){ pocetRez2Host++;}
            if(booking.getNumberOfGuestsOfOneRezervation()>2){ pocetRezViacHost++;}
            }
        System.out.println("Celkovy pocet rezervacii  s jednym hostom je : "+pocetRez1Host);
        System.out.println("Celkovy pocet rezervacii  s dvoma hostmy je : "+pocetRez2Host);
        System.out.println("Celkovy pocet rezervacii  s viac ako dva hostmy je : "+pocetRezViacHost);
    }

    private static  void fillBookings(BookingManager bookingManager, List<Booking> bookings){
        bookingManager.addBookingList(bookings);

    }


    private static void printBookings(List<Booking> allBookings) {
        System.out.println("Zoznam vsetkych rezervacii: ");
        System.out.println("      Od             do              Meno hosťa  Narodený/á[hostí,výh.more] cena   počet dní        cenaPobytu");
        DateTimeFormatter formatterCZ = DateTimeFormatter.ofPattern("d. M. yyyy");
        for (Booking booking : allBookings) {
            String seaView = booking.getRoom().isSeaView() ? "ano" : "nie";
            System.out.println(booking.getStartDate().format(formatterCZ) +"     "
                    + booking.getEndDate().format(formatterCZ) +"       "+ booking.getMainGuest()
                    +"[" +booking.getNumberOfGuestsOfOneRezervation()+","+ seaView+" ]"+"    "
                    +booking.getRoom().getPricePerNight()+"        "+booking.getBookingLength()+"      "
                    +booking.getPrice()+"    "+booking.getPrice());
        }
    }




    private static void printRekreacnyTypOfRezervation(int limit,List<Booking> allBookings) {
        System.out.println("Vypis prvých  " +prevodNaSlova(limit) +" rekreacných rezervacii:");
        int pocetRekreacnychRezervacii = 0;
        for (Booking booking : allBookings) {
            if(booking.getTypeOfVacation().equals(VacationType.REKREACNY) && pocetRekreacnychRezervacii<limit){
                pocetRekreacnychRezervacii++;
                System.out.println(booking.getMainGuest()+"    "+booking.getTypeOfVacation());
            }
        }

    }

    private static String prevodNaSlova(int number) {
        String slovo;
        switch (number) {
            case 0: slovo = "nula";   break;
            case 1:slovo = "jedna";break;
            case 2:slovo = "dvě"; break;
            case 3:slovo = "tři";break;
            case 4:slovo = "čtyři";break;
            case 5:slovo = "pět";break;
            case 6:slovo = "šest";break;
            case 7:slovo = "sedm"; break;
            case 8:slovo = "osm";break;
            case 9:slovo = "devět";break;
            case 10:slovo = "deset";break;
            default:slovo = "Nepodporované číslo";
        }
        return slovo;
    }
}





