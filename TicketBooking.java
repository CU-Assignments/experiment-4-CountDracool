import java.util.*;

class TicketBookingSystem {
    private final Set<Integer> bookedSeats = new HashSet<>();
    
    synchronized boolean bookSeat(int seat) {
        if (bookedSeats.contains(seat)) return false;
        bookedSeats.add(seat);
        return true;
    }
}

class TicketBookingThread extends Thread {
    TicketBookingSystem system;
    int seat;

    TicketBookingThread(TicketBookingSystem system, int seat, int priority) {
        this.system = system;
        this.seat = seat;
        setPriority(priority);
    }

    public void run() {
        if (system.bookSeat(seat)) System.out.println(getName() + " booked seat " + seat);
        else System.out.println(getName() + " failed to book seat " + seat);
    }
}

public class TicketBooking {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem();
        Thread vip1 = new TicketBookingThread(system, 1, Thread.MAX_PRIORITY);
        Thread normal1 = new TicketBookingThread(system, 1, Thread.MIN_PRIORITY);
        vip1.start();
        normal1.start();
    }
}
