import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class OnlineReservationSystem {
    private static boolean[] seats = new boolean[20];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Reservation System");
        System.out.print("Enter your username: ");
        String username = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        if (isValidPassword(password)) {
            System.out.println("Login successful!");
            runReservationSystem();
        } else {
            System.out.println("Invalid password. Exiting program.");
        }
    }

    private static void runReservationSystem() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nPlease enter an option!");
            System.out.println("1. View Seat Map.");
            System.out.println("2. Reserve Seat.");
            System.out.println("3. Cancel Reservation.");
            System.out.println("4. Exit.");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    viewSeatMap();
                    break;

                case 2:
                    reserveSeat();
                    break;

                case 3:
                    cancelReservation();
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Invalid Option!");
            }
        }
    }

    private static void viewSeatMap() {
        System.out.println("\nCurrent Seat Map:");
        for (int i = 0; i < seats.length; i++) {
            if (i % 5 == 0) {  
                System.out.print("| ");
            }

            
            System.out.printf("%3s ", seats[i] ? "X" : String.format("%d", i + 1));

            if (i % 5 == 4) {  
                System.out.println("|");
            }
        }

        if (seats.length % 5 != 0) {
            System.out.println("|");
        }
    }

    private static void reserveSeat() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter seat number (1-20)");
        int seatNumber = sc.nextInt();
        if (seatNumber < 1 || seatNumber > 20) {
            System.out.println("Invalid seat number");
        } else if (seats[seatNumber - 1]) {
            System.out.println("The seat is already reserved.");
        } else {
            seats[seatNumber - 1] = true;
            System.out.println("The selected seat has been successfully reserved.");
        }
    }

    private static void cancelReservation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the seat number (1-20)");
        int seatNumber = sc.nextInt();
        if (seatNumber < 1 || seatNumber > 20) {
            System.out.println("Invalid seat number");
        } else if (!seats[seatNumber - 1]) {
            System.out.println("Seat Not Reserved.");
        } else {
            seats[seatNumber - 1] = false;
            System.out.println("Reservation Cancelled.");
        }
    }

    public static boolean isValidPassword(String password) {
        String regex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=]).+$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }
}
