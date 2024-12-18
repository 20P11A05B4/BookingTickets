import java.util.Scanner;

class Movie {
    private String title;
    private String genre;
    private int availableTickets;

    public Movie(String title, String genre, int availableTickets) {
        this.title = title;
        this.genre = genre;
        this.availableTickets = availableTickets;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public boolean bookTicket(int numberOfTickets) {
        if (numberOfTickets <= availableTickets) {
            availableTickets -= numberOfTickets;
            return true;
        } else {
            return false;
        }
    }
}

class TicketBookingSystem {
    private Movie[] movies;

    public TicketBookingSystem(Movie[] movies) {
        this.movies = movies;
    }

    public void showMovies() {
        System.out.println("Available Movies:");
        for (int i = 0; i < movies.length; i++) {
            System.out.println((i + 1) + ". " + movies[i].getTitle() + " - " + movies[i].getGenre() + " - Tickets Available: " + movies[i].getAvailableTickets());
        }
    }

    public boolean bookMovie(int movieIndex, int numberOfTickets) {
        if (movieIndex >= 0 && movieIndex < movies.length) {
            Movie selectedMovie = movies[movieIndex];
            return selectedMovie.bookTicket(numberOfTickets);
        }
        return false;
    }
}

public class Booking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create some sample movies
        Movie[] movies = {
            new Movie("Salar", "Action", 50),
            new Movie("Avengers", "Action", 30),
            new Movie("Devara", "Action", 45),
            new Movie("Pushpa", "Action", 50)
        };

        // Initialize ticket booking system with available movies
        TicketBookingSystem bookingSystem = new TicketBookingSystem(movies);

        // User interaction loop
        boolean keepRunning = true;
        while (keepRunning) {
            bookingSystem.showMovies();
            System.out.print("Enter the movie number to book tickets (or 0 to exit): ");
            int movieChoice = scanner.nextInt();

            if (movieChoice == 0) {
                keepRunning = false;
            } else if (movieChoice > 0 && movieChoice <= movies.length) {
                System.out.print("Enter number of tickets to book: ");
                int numberOfTickets = scanner.nextInt();

                boolean success = bookingSystem.bookMovie(movieChoice - 1, numberOfTickets);
                if (success) {
                    System.out.println("Booking successful!");
                } else {
                    System.out.println("Booking failed. Not enough tickets available.");
                }
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }

        System.out.println("Thank you for using the Movie Ticket Booking System!");
        scanner.close();
    }
}

